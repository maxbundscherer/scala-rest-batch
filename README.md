# Scala-Rest-Batch

[![shields.io](http://img.shields.io/badge/license-Apache2-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.txt)
[![Travis](https://img.shields.io/travis/rust-lang/rust.svg)](#)

**A scala rest-client for batch-jobs**

Author: [Maximilian Bundscherer](https://bundscherer-online.de)

## Let´s get started

- Create ``.json``-files in ``./jobs/`` with this structure:

```
{
  "requestName" : "My first request",
  "requestTargetUrl" : "google.de",
  "requestTargetPort" : "80",
  "requestType" : "GET",
  "headerParams" : [
    {
      "key" : "<KEY_1>",
      "value" : "<VALUE_1>"
    },
    {
      "key" : "<KEY_2>",
      "value" : "<VALUE_2>"
    }
  ],
  "body" : "<BODY_PAYLOAD>"
}
```

- Run ``sbt clean run``
- See results in terminal

## Note

- You can use ``GET``, ``POST``, ``PUT``, ``PATCH``, ``DELETE`` in ``requestType``

## Included dependencies

- [Scala HTTP Client 'sttp'](https://github.com/softwaremill/sttp)
- [Scala JSON Library 'circe'](https://github.com/circe/circe)