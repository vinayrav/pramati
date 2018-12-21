import requests

account_id='91f679ee-82b7-43b3-9603-71b39782269e'
headers = {'Accept': 'application/json','Authorization': 'Bearer eyJ0eXAiOiJNVCIsImFsZyI6IlJTMjU2Iiwia2lkIjoiNjgxODVmZjEtNGU1MS00Y2U5LWFmMWMtNjg5ODEyMjAzMzE3In0.AQgAAAABAAUABwAAEQT_E2fWSAgAAFEnDVdn1kgCACRWOR8nUCtDiIV8E-dJYMIVAAEAAAAYAAEAAAAFAAAADQAkAAAANDk2NTJjOWUtOWEzMy00N2ViLWI2NzUtM2FmZjYyYjVlNGE0MACAd8qgNl_WSA.ywGJ_4fyyarLU4F13fBMKNocs0Rf-qLw1qaXI94KgAcKiG-IvMwK05nftbYGoqh-sKfZmTKDz1cOEtPo8ghHCIWV7Xnn30YZZrGxJnlgjwU2pQbJkS5lBPHgWnGLS1Id24u5JoxLHnKe_RFZY-IyL15sUA7QXbv30LROwtP-EdXoL_OvtoRQJhYK1mqshXnuz-64gBtgJYlIoa9afzDLz9Ug6zo_qEY5ecW2sPEQPPAJw4mfb-u5H6nbqes0zVyDVWGROa6_-XxvjroNTZa6osZASbA3Kz5YcPcTA1v6hKcI3us1AIJTNRhOQBnro6jDd8tJW60C8qjOsEq2OQQ2-A'}

def recipientInfo():
  url = 'https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/users?email=vinayr0325@gmail.com'
  r = requests.get(url, headers=headers)
  print(r.status_code)
  print(r.text)

def createEnvelope():
  url='https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/envelopes'
  files = {'file': ('sign.json', open('sign.json', 'rb'), 'application/json')}
  r = requests.post(url, files=files, headers=headers)
  print(r.text)

def envelopeDetails():
  url='https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/envelopes/207e23e0-4e96-41e5-a9ea-c32d2f526b69/documents'
  r = requests.get(url,headers=headers)
  print(r.text)

def downloadDocument():
  url='https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/envelopes/207e23e0-4e96-41e5-a9ea-c32d2f526b69/documents/1'
  r = requests.get(url,headers=headers)
  with open('vny.pdf', 'wb') as f:
    f.write(r.content)


recipientInfo()
envelopeDetails()
downloadDocument()
createEnvelope()
