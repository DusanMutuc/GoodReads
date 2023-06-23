<template>
    <router-link :to="'/zanr/'+zanr.naziv ">{{zanr.naziv}}</router-link><br/>
</template>
<script>
    export default {
        name: 'zanrComp',
        props: ["zanr"]
    }
</script>