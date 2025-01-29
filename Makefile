APP_SERVICE_NAME=app
BUILDER_SERVICE_NAME=builder
DOCKER_SCAN_SERVICE_NAME=docker-scan

DOCKER_TAG=latest

APP_NAME=llm-adapter
APP_PORT=4326

NAMESPACE=llm-adapter
HELM_CHART=helm-chart

DOCKER_SCAN_ARGS=
DOCKER_SCAN_INPUT_PATH=tmp/$(APP_NAME)-$(DOCKER_TAG).tar
DOCKER_SCAN_CMD=$(DOCKER_SCAN_SERVICE_NAME) image --input $(DOCKER_SCAN_INPUT_PATH) $(DOCKER_SCAN_ARGS)

AWS_ECR_URI=localhost.localstack.cloud:4510
DOCKER_ECR_TAG="$(AWS_ECR_URI)/$(APP_NAME)"

help:
	@grep -E '^[1-9a-zA-Z_-]+:.*?## .*$$|(^#--)' $(MAKEFILE_LIST) \
	| awk 'BEGIN {FS = ":.*?## "}; {printf "\033[32m %-43s\033[0m %s\n", $$1, $$2}' \
	| sed -e 's/\[32m #-- /[33m/'

#-- gradle:
.PHONY: build
build: ## build gradle project
	docker-compose run --rm $(BUILDER_SERVICE_NAME) ./gradlew build

.PHONY: owasp-check
owasp-check:
	docker-compose run --rm $(BUILDER_SERVICE_NAME) ./gradlew dependencyCheckAnalyze -Dorg.gradle.jvmargs="--enable-native-access=ALL-UNNAMED --add-modules=jdk.incubator.vector"

#-- docker:
.PHONY: image-build
image-build: ## build docker image
	docker-compose build $(BUILDER_SERVICE_NAME)
	TAG=$(DOCKER_TAG) docker-compose build $(APP_SERVICE_NAME)

.PHONY: image-scan
image-scan: image-build ## performs a vulnerability scan on a docker image
	mkdir -p tmp
	docker save $(APP_NAME):$(DOCKER_TAG) -o $(DOCKER_SCAN_INPUT_PATH)
	docker-compose run --rm $(DOCKER_SCAN_CMD)
	rm -rf tmp

.PHONY: up
up: ## start the app
	docker-compose up $(APP_SERVICE_NAME)

.PHONY: down
down: ## stop the app, any running contains, and networking
	docker-compose down

.PHONY: debug
debug: ## debug the service container with app by running docker and shelling into it
	docker-compose exec -it $(APP_SERVICE_NAME) //bin/bash

.PHONY: destroy
destroy: ## remove the app and all containers, images and volumes
	docker-compose down -v --rmi all

#-- k8s:
.PHONY: debug-pod
debug-pod: ## debug a specific pod or the first pod in the namespace, usage: `make debug-pod POD_NAME=<pod_name> (optional)`
	$(eval POD_NAME ?= $(shell kubectl get pods -n $(NAMESPACE) -o json | jq -r '.items[0].metadata.name'))
	kubectl exec --stdin --tty -n $(NAMESPACE) ${POD_NAME} -- /bin/bash

.PHONY: port-forward
port-forward: ## make port forward to k8s service
	kubectl port-forward -n $(NAMESPACE) svc/$(APP_NAME) $(APP_PORT):$(APP_PORT)

#-- helm:
.PHONY: helm-lint
helm-lint: ## lint helm chart
	helm lint $(HELM_CHART)

.PHONY: helm-install
helm-install: ## install helm chart (default)
	helm upgrade -i $(APP_NAME) $(HELM_CHART) -n $(NAMESPACE) --values local.values.yaml --create-namespace

.PHONY: helm-delete
helm-delete: ## uninstall helm chart
	helm delete $(APP_NAME) -n $(APP_NAME)
