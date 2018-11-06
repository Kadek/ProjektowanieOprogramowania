import requests


#TEST pobierz_zamowienia
r1 = requests.get("http://127.0.0.1:5000/pobierz_zamowienia", params={'id_restauracji': 0})
print(r1.text)


if r1.text == '[[1,[[1,"Ciastko"],[2,"Kawa"],[3,"Bulka"]],"Gotowe"],[2,[[1,"Ciastko"],[2,"Kawa"],[3,"Bulka"]],"Oczekujace"],[3,[[1,"Ciastko"],[2,"Kawa"],[3,"Bulka"]],"Anulowane"]]':
    print("SUCCESS!")
else:
    print("FAILURE!")


#TEST zmien_status zamowienia
r1 = requests.post("http://127.0.0.1:5000/zmien_status_zamowienia", data={'id_zamowienia': 1, 'status': "Anulowane"})
print(r1.text)


if r1.text == 'Zmieniono status zamowienia o id=1, na Anulowane':
    print("SUCCESS!")
else:
    print("FAILURE!")