package org.http4k.connect.github

import dev.forkhandles.values.NonBlankStringValueFactory
import dev.forkhandles.values.StringValue

enum class CallbackEvent {
    check_run,
    check_suite,
    code_scanning_alert,
    commit_comment,
    content_reference,
    create,
    delete,
    deploy_key,
    deployment,
    deployment_status,
    fork,
    github_app_authorization,
    gollum,
    installation,
    installation_repositories,
    issue_comment,
    issues,
    label,
    marketplace_purchase,
    member,
    membership,
    meta,
    milestone,
    organization,
    org_block,
    `package`,
    page_build,
    ping,
    project_card,
    project_column,
    project,
    `public`,
    pull_request,
    pull_request_review,
    pull_request_review_comment,
    push,
    release,
    repository_dispatch,
    repository,
    repository_import,
    repository_vulnerability_alert,
    secret_scanning_alert,
    security_advisory,
    sponsorship,
    star,
    status,
    team,
    team_add,
    watch,
    workflow_dispatch,
    workflow_job,
    workflow_run
}

class GitHubToken private constructor(value: String) : StringValue(value) {
    companion object : NonBlankStringValueFactory<GitHubToken>(::GitHubToken)
}
