# rpb-uploader-basic-webservices
Basic webservices to run the rpb-uploader

The Uploader basic webservice is part of the [RPB Infrastructure](https://github.com/ddRPB/rpb#radiotherapy-clinical-research-it-infrastructure). It facilitates the usage of the [RPB uploader](https://github.com/ddRPB/rpb-uploader) by providing a basic web service interface without requiring the full [RPB portal](https://github.com/ddRPB/rpb/tree/master/radplanbio-portal/src/main/java/de/dktk/dd/rpb/api/v1).

## Getting Started

### Prerequisits

Prerequisits to work with the basic web services are the RPB uploader and a [Tomcat 11](https://tomcat.apache.org/download-11.cgi).

### Clone Repository

```
git clone git@github.com:ddRPB/rpb-uploader-basic-webservices.git
```

### Deployment

#### Quickstart from precompiled .war file
Download the .war file from the [current release](https://github.com/ddRPB/rpb-uploader-basic-webservices/releases). Rename the file to ROOT.war and place it in the webapps folder in your tomcat directory.

#### Build from source
Copile the source code with
```
mvnw package
```
and rename the created .war file to ROOT.war. Place it in the webapps folder in your tomcat directory.

### Start the App

Start the tomcat.


