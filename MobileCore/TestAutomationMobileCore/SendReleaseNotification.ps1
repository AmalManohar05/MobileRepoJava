    # Get the directory where the current script is located
    $currentScriptDirectory = Split-Path -Path $MyInvocation.MyCommand.Path -Parent

    # Set the working directory to the script directory
    Set-Location -Path $currentScriptDirectory

    $pomFile = "pom.xml"  # Specify the path to your pom.xml here
    [xml]$pom = Get-Content $pomFile
    $namespace = @{ "ns" = "http://maven.apache.org/POM/4.0.0" }
    $mavenVersion = Select-Xml -Xml $pom -Namespace $namespace -XPath "//ns:project/ns:version" | ForEach-Object { $_.Node.InnerXml }
    if (-not $mavenVersion) {
        Write-Error "Failed to retrieve a valid Maven version"
        exit 1
    }

    $payload = @{
        type = "message"
        attachments = @(
            @{
                contentType = "application/vnd.microsoft.card.adaptive"
                contentUrl = $null
                content = @{
                    "$schema" = "http://adaptivecards.io/schemas/adaptive-card.json"
                    type = "AdaptiveCard"
                    version = "1.5"
                    height = "stretch"
                    width = "stretch"
                    body = @(
                        @{
                            type = "Container"
                            style = "good"
                            height = "stretch"
                            width = "stretch"
                            items = @(
                                @{
                                    type = "TextBlock"
                                    text = "PACE Mobile Core - New Maven Dependency has been released"
                                    size = "Medium"
                                    weight = "Bolder"
                                    separator = $true
                                    wrap = $true
                                    maxLines = 20
                                },
                                @{
                                    type = "TextBlock"
                                    text = "**Version:** $mavenVersion"
                                    wrap = $true
                                    maxLines = 20
                                },
                                @{
                                    type = "TextBlock"
                                    text = "Maven Dependency :"
                                    wrap = $true
                                    maxLines = 20
                                },
                                @{
                                    type = "RichTextBlock"
                                    inlines = @(
                                        @{
                                            type = "TextRun"
                                            text = "<dependency>`n<groupId>pace.testautomation</groupId>`n<artifactId>mobilecore</artifactId>`n<version>$mavenVersion</version>`n</dependency>"
                                        }
                                    )
                                },
                                @{
                                    type = "TextBlock"
                                    text = "**Major Updates:** N/A"
                                    wrap = $true
                                    maxLines = 20
                                }
                            )
                        }
                    )
                }
            }
        )
    } | ConvertTo-Json -Depth 10

    $uri = "https://pitsolutions.webhook.office.com/webhookb2/dd6510fa-9914-4842-a756-385c36e57d62@192a4d7a-44fa-49f4-b052-b8e88940ae49/IncomingWebhook/bf579d1f2e7546558d338ffae8945675/a8fe8153-a3c6-4795-97fd-0775c0ac2d5e"
    $headers = @{
        "Content-Type" = "application/json; charset=utf-8"
    }

    Invoke-RestMethod -Uri $uri -Method POST -Body $payload -Headers $headers
    Write-Host "Sent adaptive card with Maven Version $($env:mavenVersion)"