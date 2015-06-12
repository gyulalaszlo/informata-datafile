# Datafile

For more documentation, see: [http://datafile.sourceforge.net/](http://datafile.sourceforge.net/)


## About this repository

This repository is designed to allow datafile to be used from Maven.

* 100% API compatibility
* The source code has been slightly rearranged, the tests are separated
* I have corrected some tests to use proper decimal formatting (which may depend on your locales decimal format), so they wont fail on (for example) hungarian Windows installations where the decimal separators are ",".
