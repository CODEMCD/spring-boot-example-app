<template>
    <div class="home">
        <AppBar/>

        <v-content>
            <v-container>
                <v-row align="center">
                    <v-col cols="12">
                        <ArticleItems v-bind:articles="articles"/>
                    </v-col>
                </v-row>
            </v-container>
        </v-content>

        <BottomNav/>
    </div>
</template>

<script>
    // import axios from 'axios';
    import AppBar from '../components/MainAppBar.vue';
    import BottomNav from '../components/MainBottomNavigation.vue';
    import ArticleItems from '../components/ArticleItems.vue';

    export default {
        name: 'home',
        components: {
            AppBar,
            BottomNav,
            ArticleItems,
        },
        data: () => ({
            articles: null,
        }),
        created() {
            // const currentVue = this;
            // axios.get('/api/articles').then(function(response) {
            //     console.log(response);
            //     if (response.status === 200) {
            //         currentVue.articles = response.articles;
            //     }
            // }).catch(function(error) {
            //     console.log(error);
            // });

            const article1 = {
                id: 1,
                author: 'park',
                title: 'hello1',
                contents: 'bye1'
            };
            const article2 = {
                id: 2,
                author: 'park2',
                title: 'hello2',
                contents: 'bye2'
            };
            const article3 = {
                id: 3,
                author: 'park3',
                title: 'hello3',
                contents: 'bye3'
            };
            const article4 = {
                id: 4,
                author: 'park4',
                title: 'hello4',
                contents: 'bye4'
            };
            const article5 = {
                id: 5,
                author: 'park5',
                title: 'hello5',
                contents: 'bye5'
            };

            this.articles = {article1, article2, article3, article4, article5};
        },
    }
</script>
