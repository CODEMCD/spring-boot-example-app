<template>
    <v-app>
        <RwvHeader/>
        <router-view/>
        <RwvFooter/>
    </v-app>
</template>

<script>
    import RwvHeader from "./components/TheHeader";
    import RwvFooter from "./components/TheFooter"

    export default {
        name: 'App',
        components: {
            RwvHeader,
            RwvFooter
        },
        data() {
            return {}
        }
    }
</script>