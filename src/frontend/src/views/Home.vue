<template>
    <div class="home">
        <AppBar/>

        <v-content>

        </v-content>

        <BottomNav/>
    </div>
</template>

<script>
    import AppBar from '../components/MainAppBar.vue';
    import BottomNav from '../components/MainBottomNavigation.vue';

    export default {
        name: 'home',
        components: {
            AppBar,
            BottomNav,
        },
        data: () => ({
        }),
    }
</script>
