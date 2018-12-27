import requests
import urllib

account_id='91f679ee-82b7-43b3-9603-71b39782269e'
headers = {'Accept': 'application/json','Authorization': 'Bearer eyJ0eXAiOiJNVCIsImFsZyI6IlJTMjU2Iiwia2lkIjoiNjgxODVmZjEtNGU1MS00Y2U5LWFmMWMtNjg5ODEyMjAzMzE3In0.AQkAAAABAAUABwAAiuzXwGvWSAgAAMoP5gNs1kgCACRWOR8nUCtDiIV8E-dJYMIVAAEAAAAYAAEAAAAFAAAADQAkAAAANDk2NTJjOWUtOWEzMy00N2ViLWI2NzUtM2FmZjYyYjVlNGE0EgABAAAACwAAAGludGVyYWN0aXZlMACA81PXwGvWSA.NVe-LGXG5HB3yqfCAit_dmIql1vXtsLzDJHKP8U1ug0LJPUUVFWTJ5Ue4OtkiPXeR7wK-Gc2oXh70TbQ_cAfcMJFTwvJgs5eecemLEUqGfrzrvI_xrvTA8_EqZ5HWiqG7XFfWK7_viy4HgVYs6BBHCRRbsimxmyxXFZHbcvQreZEmTAFeGD_hgVgenFbaaf1OaAomWGRu3dPzglVe5uhSTFIlwKs927YEqqj-2Jdv6NQPN3qgPptlkdwixKBBNPmltvc_dimMZTG8uYp5r3HjCxsS5a3EJj8upd7wYlamXEJgUvbEZqArln9tXMfDEm8mblAe5YcEJwFx9V9rkqYzQ'}

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
  url='https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/envelopes/b07c6c01-e372-4ba4-bb4d-792e71da5f39/documents'
  r = requests.get(url,headers=headers)
  print(r.text)

def downloadDocument():
  url='https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/envelopes/b07c6c01-e372-4ba4-bb4d-792e71da5f39/documents/1'
  r = requests.get(url,headers=headers)
  with open('vny.pdf', 'wb') as f:
    f.write(r.content)


#envelopeDetails()
#downloadDocument()
createEnvelope()
recipientInfo()

