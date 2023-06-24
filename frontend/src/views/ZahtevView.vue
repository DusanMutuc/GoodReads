<template>
    <h1>Zahtev</h1>
    <form>
        <label >email:</label><br/>
        <input  v-model ="zahtevDto.email"> <br/>
        <label >telefon:</label><br/>
        <input  v-model="zahtevDto.telefon"><br/>
        <label >poruka:</label><br/>
        <input  v-model="zahtevDto.poruka"><br/>
        <button v-on:click="submit()">Podnesi Zahtev</button>
    </form> 
</template>
<script>

export default {
    name: 'ZahtevViewView',
    data: function() {
        return {
            zahtevDto: {
                idAutor: 0,
                email: '',
                telefon: '',
                poruka: ''
            }
        }
    },
    methods: {
        submit: function() {
            fetch('http://localhost:1237/api/zahtevi/aktivacija', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    idAutor: this.$route.query.id,
                    email: this.zahtevDto.email,
                    telefon: this.zahtevDto.telefon,
                    poruka: this.zahtevDto.poruka
                })
            })
            .then(
                this.$router.push('/')
                )
            .catch(error => {
                console.log(error);
            })
        }
    }
}
</script>