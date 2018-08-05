# Overview
The goal of this project is to create a proof of concept service application that reads AWS CloudWatch logs and pushes them to Graylog in GELF (Graylog Enhanced Log Format) via HTTP. For applications hosted in the AWS environment, it is a common practice to push application logs to CloudWatch logs, so the thinking is, it might be useful to have a way to transfer those logs to Graylog. Perhaps sometime in the future, this code could be migrated to a Graylog plugin (or the existing Graylog AWS plugin). The idea here is to start simple to prove out all of the components.

This project is still in early development stages.

