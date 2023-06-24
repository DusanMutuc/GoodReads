<template>
    <h1>Login</h1>
    <form>
        <label >email:</label><br/>
        <input v-model="LoginDto.email"> <br/>
        <label >password:</label><br/>
        <input  v-model="LoginDto.lozinka"><br/>
        <button v-on:click="submit()">log in</button> <br/>
    </form> 
</template>

<script>
import axios from 'axios'
export default {
    name: 'LoginView',
    data: function() {
        return {
            LoginDto: {
                email: '',
                lozinka: ''
            }
        }
    },
    methods: {
        submit: async function() {
            this.$cookies.remove('JSESSIONID')
            await axios
            .post('http://localhost:1237/api/login', this.LoginDto)
            .then(response => {
                console.log(response.data.cookie)
                this.$cookies.set('JSESSIONID', response.data.cookie)
                console.log(response.data.uloga)
                this.$cookies.set('ULOGA', response.data.uloga)
                console.log(response.data.id)
                this.$cookies.set('ID', response.data.id)
                this.$router.push('/profile')
            })
            .catch(error => {
                console.log(error);
            })
        }
    }
}
</script>