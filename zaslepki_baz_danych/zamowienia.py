from flask import Flask, request, render_template, jsonify

app = Flask(__name__)


@app.route('/')
def main_site():
    return render_template('test.html')


@app.route('/dodaj_zamowienie', methods=['POST'])
def dodaj_zamowienie():
    if request.form['id_klienta'] is None:
        return "ERROR. Nie moge dostac sie do id klienta"
    id_klienta = int(request.form['id_klienta'])

    if request.form['id_restauracji'] is None:
        return "ERROR. Nie moge dostac sie do id restauracji"
    id_restauracji = int(request.form['id_restauracji'])

    if request.form['lista_dan'] is None:
        return "ERROR. Nie moge dostac sie do listy dan"
    lista_dan = request.form['lista_dan']

    if request.form['kwota'] is None:
        return "ERROR. Nie moge dostac sie do kwoty"
    kwota = float(request.form['kwota'])
    print("KWA")
    return '44'


if __name__ == '__main__':
    app.run()
