<template>
    <div>
        <AppBar/>

        <v-content>
            <v-container>
                <v-row>
                    <MarkdownEditor/>
                </v-row>
                <v-row>
                    <v-col class="text-center">
                        <v-btn min-width="50%" color="#64B587">작성 완료</v-btn>
                        <v-btn min-width="50%" color="#64B587">취소</v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-content>

        <BottomNav/>
    </div>
</template>

<script>
    import AppBar from '../components/MainAppBar.vue';
    import BottomNav from '../components/MainBottomNavigation.vue';
    import MarkdownEditor from "../components/MarkdownEditor.vue";

    export default {
        name: 'writingArticle',
        components: {
            AppBar,
            BottomNav,
            MarkdownEditor
        },
        data: () => ({}),
    }
</script>