# Dispatch-Tracking-Lib

This is a library project for dispatch and tracking projects. It provides the messaging DTOs and
events (`OrderCreated`, `OrderDispatched`, `DispatchPreparing`, `DispatchCompleted`,
`TrackingStatusUpdated`, `TrackingStatus`) in the package `dev.lydtech.message`. The downstream
Spring Boot apps [`dboeckli/dispatch`](https://github.com/dboeckli/dispatch) and
[`dboeckli/tracking`](https://github.com/dboeckli/tracking) consume this jar as a Maven dependency
from GitHub Packages.

The module is built on Java 25 with Maven (`./mvnw`). Build and test commands, the required toolchain,
and the enforced formatting (spring-javaformat + spotless) are documented in
[`AGENTS.md`](AGENTS.md).

## Sandbox (local dev environment)

The sandbox is provisioned by the opencode-sandbox-kit and runs as a Docker container. It mounts this
repo, starts the agent, and connects the IntelliJ MCP server.

Allow the kit source (GitHub without cloning):

```powershell
sbx settings set kit.allowedSources --% "[\"docker.io/\",\"github.com/dboeckli/\"]"
```

Start a new sandbox:

```powershell
sbx run opencode `
    --kit "git+https://github.com/dboeckli/opencode-sandbox-kit.git#dir=opencode-agent" `
    --template docker/sandbox-templates:opencode-docker-0.5.0 `
    --no-share-skills `
    --static-mcp idea `
    . `
    "C:\development\maven-repo:ro"
```

Start the sandbox with Kubernetes support:

```powershell
sbx run opencode `
    --kit "git+https://github.com/dboeckli/opencode-sandbox-kit.git#dir=opencode-agent" `
    --template docker/sandbox-templates:opencode-docker-0.5.0 `
    --no-share-skills `
    --static-mcp idea `
    . `
    "C:\development\maven-repo:ro" `
    "$env:USERPROFILE\.kube:ro"
```

Apply the kit to an existing sandbox (restarts the sandbox, VM state is kept):

```powershell
sbx kit add <sandbox-name> "git+https://github.com/dboeckli/opencode-sandbox-kit.git#dir=opencode-agent"
```

