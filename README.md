# LLM Adapter

![CI Status](https://github.com/lomasz/llm-adapter/workflows/CI/badge.svg)

## Description

TODO

## :memo: Prerequisites

Before you begin, ensure you have met the following requirements:

* `make`
* `pre-commit`
* `docker` + `kubectl`
* `helm`
* `hadolint`
* `jq`

For :apple: macOS users, you can use the [`Brewfile`](Brewfile) script to simplify the installation of all the
necessary dependencies.

If you have Homebrew installed, follow these steps:

```bash
brew bundle
````

## :rocket: Getting Started

To see a list of available commands, run command:

```bash
make
```

## :stethoscope: Actuator

* [`http://localhost:4326/actuator/health`](http://localhost:4326/actuator/health) - health information (status)

## :sunglasses: API Documentation

* [`http://localhost:4326/v3/api-docs`](http://localhost:4326/v3/api-docs) - API Docs [JSON]
* [`http://localhost:4326/v3/api-docs.yaml`](http://localhost:4326/v3/api-docs.yaml) - API Docs [YAML]
* [`http://localhost:4326/swagger-ui.html`](http://localhost:4326/swagger-ui.html) - Swagger UI
