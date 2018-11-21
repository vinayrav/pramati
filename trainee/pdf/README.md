# Project 
PDFBox Digital Signature

##About PDFBox
PDFBox is an open-source Java library
It can be used to create, render, print, split, merge, alter, verify and extract text and meta-data of PDF files.

### Prerequisites
Install Maven

# Project files
```
### DigitalSign
 Creates signature base
 Initializes the signature creator with a keystore (pkcs12) and pin that should be used for the signature
 Signs pdf file and create new file that ends with "signed.pdf" with signature
 Arguments included
 [0] key store
 [1] pin
 [2] document that needs to be signed
 [3] image of visible signature
### Verify
 Verifies Signature
 Arguments are
 [0] password
 [1] Signed pdf location
###pomfile
 Includes dependencies

```
## Author
Vakhtang Koroghlishvili
 
