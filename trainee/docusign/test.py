import requests

account_id='31524907-e59d-46e6-b7f7-1ef93149f2a5'
headers = {'Accept': 'application/json','Authorization': 'Bearer eyJ0eXAiOiJNVCIsImFsZyI6IlJTMjU2Iiwia2lkIjoiNjgxODVmZjEtNGU1MS00Y2U5LWFmMWMtNjg5ODEyMjAzMzE3In0.AQgAAAABAAUABwAAhra1tWTWSAgAAMbZw_hk1kgCAG3Tr024XZdBsUN30c1gEWIVAAEAAAAYAAEAAAAFAAAADQAkAAAANWFmMjA5MzQtYTNhNy00NWRlLWEwMDItZTg5NDE2YWFiY2U4MACAxa42l17WSA.5Hx4FRP_KNUXRMsCIvw3-8YDGBe3XPR532u_-rnVhTw8vCYT96VSt3m7zYYDiSwcNqX279RJhaSBva2nltX-85RkRyDZTMvtAgsKUWY8N-ra77bBNnO0ZI48SBa67CeqIYPWsOyiLsZhiIkpp467QejM7a5QWC5R4VcAYdwuqVq_QyXRgrTu7A8h4Be6ML9ydWRbnWBrrFCcz97iEcHri5IYCi8a4qro72EyuKuRGnmsqnyy8GE44Bb5hVVVw6sxg7baa_Dt1-jiQntflxr24ZzpF5BiwzZUeh0LxFiS3zwUdiWPhUJlREn4xUJFRixP-3ncrzC5f6j14p0wrTjxzA'}

def recipientInfo():
  url = 'https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/users?email=krohithvarma1997@gmail.com'
  r = requests.get(url, headers=headers)
  print(r.status_code)
  print(r.text)

def createEnvelope():
  url='https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/envelopes'
  files = {'file': ('demo.json', open('demo.json', 'rb'), 'application/json')}
  r = requests.post(url, files=files, headers=headers)
  print(r.text)

def envelopeDetails():
  url='https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/envelopes/22c09a49-b2e6-48a8-8f5c-fdff642132b3/documents'
  r = requests.get(url,headers=headers)
  print(r.text)

def downloadDocument():
  url='https://demo.docusign.net/restapi/v2/accounts/'+account_id+'/envelopes/22c09a49-b2e6-48a8-8f5c-fdff642132b3/documents/1'
  r = requests.get(url,headers=headers)
  with open('sampledoc.pdf', 'wb') as f:
    f.write(r.content)


recipientInfo()
# envelopeDetails()
# downloadDocument()
# createEnvelope()