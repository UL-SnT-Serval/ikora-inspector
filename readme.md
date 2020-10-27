# Ikora Inspector

Static analysis for Robot Framework generating a sqlite database to be consumed by a data viewer

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisite

To be able to install Ikora Inspector, you will need the following:
- Java JDK 1.8
- Maven 3.8 or higher

### Testing

1. Clone the project on your machine using git clone https://github.com/UL-SnT-Serval/ikora-inspector.git
2. Move to the directory
3. run mvn clean test

This will run the test suite and ensure that all the requirements are met.

## Deployment

### Generate package

1. Move to the directory
2. run mvn clean package

### Configuration file

#### Configuration to load project from local file system

    {
      "output database": {
        "location": "path/to/db.sqlite",
        "driver": "sqlite"
      },
      "local source": {
        "folders": [
          "src/main/resources/project-suite/project-A",
          "src/main/resources/project-suite/project-B",
          "src/main/resources/project-suite/project-C"
        ]
      }
    }

where *output database* is the path to which the database should be created. The file should not exist but the directory should. 
*local source* describe where to find the project on the local file system. The engine allows to analyse multiproject structures
hence, the user can define a list of folder to load from the file system. Note that if all the project are located in the
same base folder and the user just defines it as the project folder, then all the projects will be consider as one project
with different libraries. 

#### Configuration to load project from Gitlab

    {
        "output directory": "/path/to/output/directory/database.sqlite",
        "gitlab": {
            "url": "https://url/to/gitlab",
            "group": "gitlab-group-name",
            "default branch": "name-default-branch",
            "branch exception": {
                "project1":"branch1",
                "project2":"branch2"
            },
            "local folder":"/path/to/folder/to/checkout"
        }
    }

### Running

To launch the analysis run java -jar ikora-inspector.jar -config /path/to/config.json