<template>
    <h1>Register</h1>
    <form>
        <label >email:</label><br/>
        <input  v-model ="RegisterDto.mail"> <br/>
        <label >ime:</label><br/>
        <input  v-model="RegisterDto.ime"><br/>
        <label >prezime:</label><br/>
        <input  v-model="RegisterDto.prezime"><br/>
        <label >korisnickoIme:</label><br/>
        <input  v-model="RegisterDto.korisnickoIme"><br/>
        <label >password:</label><br/>
        <input  v-model="RegisterDto.lozinka"><br/>
        <label >confirm password:</label><br/>
        <input  v-model="RegisterDto.lozinkaConfirmation"><br/>
        <button v-on:click="submit()"> register</button>
    </form> 
</template>
<script>
export default {
    name: 'RegisterView',
    data: function() {
        return {
            RegisterDto: {
                ime: '',
                mail: '',
                lozinka: '',
                prezime: '',
                lozinkaConfirmation: '',
                korisnickoIme: ''
            }
        }
    },
    methods: {
        submit: function() {
            
            fetch('http://localhost:1237/api/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.RegisterDto)
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