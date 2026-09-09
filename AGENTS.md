# AGENTS.md

Reine Java-Library (Maven, `<packaging>jar</packaging>`) auf **Java 25** (Spring Boot Parent 4.1.1,
`spring-boot-starter-parent`). Package `dev.lydtech.message` — enthält nur Messaging-DTOs/Events
(`OrderCreated`, `OrderDispatched`, `DispatchPreparing`, `DispatchCompleted`, `TrackingStatusUpdated`,
`TrackingStatus`); **kein** `@SpringBootApplication`, kein Docker/Helm/Kubernetes. Publiziert als
Maven-Artefakt auf **GitHub Packages** (`maven.pkg.github.com/dboeckli/dispatch-tracking-lib`) und wird
von den Apps `dispatch`/`tracking` als Dependency konsumiert.

## Build & test commands

- Full build: `./mvnw clean install` — format checks (`validate`), unit tests, package.
- Unit tests only: `./mvnw test`. Single test: `./mvnw test -Dtest=OrderCreatedTest`.
- Format check only: `./mvnw validate` (spring-javaformat + spotless).

After changing code, always verify: run the relevant Maven goal above and report its output
(evidence, not just "done").

## Sandbox build quirk (background)

This sandbox mounts the repo via filesystem passthrough, which blocks symlinks — Spotless's
`npm install` (prettier) would fail with `EPERM` unless npm skips bin links. The sandbox kit sets
`npm_config_bin_links=false` globally (`spec.yaml` → `environment.variables`), so no manual export
is needed here. On a normal host (Windows/CI) this does not apply either.

## Formatting is enforced (fails the `validate` phase)

- Java: Spring Java Format → fix with `./mvnw spring-javaformat:apply`.
- Everything else (pom.xml, `**/*.md`, json, `src/main/resources/application*.yaml`, `**/*.sh`):
  Spotless → fix with `./mvnw spotless:apply`.
- `AGENTS.md` und `CLAUDE.md` sind bewusst von der Markdown-Formatierung ausgenommen
  (Spotless-Excludes); README.md und andere `.md`-Dateien müssen flexmark-clean bleiben — nach
  Markdown-Edits `./mvnw spotless:apply` ausführen.
- shfmt wird in `pom.xml` (Spotless) und den Workflows (`mfinelli/setup-shfmt`) synchron von Renovate
  gepflegt — Versionen nicht manuell auseinanderziehen.

## External dependency gotcha

- Die Klassen sind Plain-DTOs/Events für Kafka-Brokereignisse — keine Datenbank, kein Web-Layer.
- Version bumps kommen via Renovate (Maven- + shfmt-Manager); Spring-Boot-Parent-Version und
  `java.version`-Property synchron halten.
