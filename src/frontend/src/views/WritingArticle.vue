<template>
    <div>
        <AppBar/>

        <v-content>
            <MarkdownEditor v-on:passArticle="requestSaveArticle"/>
        </v-content>

        <BottomNav/>
    </div>
</template>

<script>
    import axios from 'axios';
    import AppBar from '../components/MainAppBar.vue';
    import BottomNav from '../components/MainBottomNavigation.vue';
    import MarkdownEditor from "../components/ArticleMarkdownEditor.vue";

    export default {
        name: 'writingArticle',
        components: {
            AppBar,
            BottomNav,
            MarkdownEditor
        },
        data: () => ({}),
        methods: {
            requestSaveArticle: function(article) {
                const currentVue = this;
                console.log(article);
                const articleRequestDto = {
                    author: "park",
                    title: article.title,
                    contents: article.contents
                };

                axios.post('/api/articles', articleRequestDto).then(function(response) {
                    console.log(response);
                    if (response.status === 200) {
                        currentVue.$router.push('/');
                    }
                }).catch(function(error) {
                    console.log(error);
                })
            }
        }
    }
</script>