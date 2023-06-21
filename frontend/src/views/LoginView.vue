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
        submit: function() {
            fetch('http://localhost:1237/api/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.LoginDto)
            })
            .then(response => {
                console.log(response)
                this.$router.push('/logged')
            })
            .catch(error => {
                console.log(error);
            })
        }
    }
}
</script>