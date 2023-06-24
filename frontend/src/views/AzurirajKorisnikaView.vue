<template>
    <form>
        <label>Ime</label>
        <input v-model="this.korisnik.ime">
        <label>Prezime</label>
        <input v-model="this.korisnik.prezime">
        <label>Datum rodjenja</label>
        <input type="date" v-model="this.korisnik.datumRodjenja">
        <label>Opis</label>
        <input type="textbox" v-model="this.korisnik.opis">
        <button v-on:click="submit()">Azuriraj</button>
    </form>
</template>

<script>
import axios from 'axios'
export default {
    name: 'AzurirajKorisnikaView',
    data: function () {
        return {
            korisnik: {
                id: 0,
                ime: '',
                prezime: '',
                datumRodjenja: '',
                opis: ''
            }
        }
    },
    mounted: function () {
        axios
        .get('http://localhost:1237/api/korisnici/' + this.$cookies.get('ID'))
        .then(response => {
            this.korisnik = response.data
        })
    },
    methods: {
        submit() {
            var str = ''
            if (this.korisnik.ime)
                str = str + 'ime=' + this.korisnik.ime + '&'
            if (this.korisnik.prezime)
                str = str + 'prezime=' + this.korisnik.prezime + '&'
            if (this.korisnik.datumRodjenja)
                str = str + 'datumRodjenja=' + this.korisnik.datumRodjenja + '&'
            if (this.korisnik.opis)
                str = str + 'opis=' + this.korisnik.opis

            axios
            .post('http://localhost:1237/api/korisnik/update', str, {withCredentials:true})
            .catch(error => { console.error(error) })
        }
    }
}
</script>