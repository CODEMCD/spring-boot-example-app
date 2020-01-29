<template>
    <v-container>
        <v-row>
            <v-col>
                <v-text-field label="제목" v-model="title" :rules="rules" hide-details="auto"/>
                <editor
                        v-model="contents"
                        :value="contents"
                        :options="editorOptions"
                        :html="editorHtml"
                        :visible="editorVisible"
                        previewStyle="vertical"
                        height="400px"
                        mode="wysiwyg"
                />
            </v-col>
        </v-row>
        <v-row>
            <v-col class="text-center">
                <v-btn min-width="50%" color="#64B587" v-on:click="passArticle">작성 완료</v-btn>
                <v-btn min-width="50%" color="#64B587" v-on:click="goHome">취소</v-btn>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import 'tui-editor/dist/tui-editor.css';
    import 'tui-editor/dist/tui-editor-contents.css';
    import 'codemirror/lib/codemirror.css';
    import Editor from '@toast-ui/vue-editor/src/Editor.vue'

    export default {
        components: {
            'editor': Editor,
        },
        data: () => ({
            contents: '',
            editorOptions: {
                hideModeSwitch: true
            },
            editorHtml: '',
            editorVisible: true,
            title: '',
            rules: [
                value => !!value || 'Required.',
                value => (value && value.length >= 3) || 'Min 3 characters',
            ],
        }),
        methods: {
            goHome: function () {
                this.$router.push('/');
            },
            passArticle: function () {
                const article = {
                    title: this.title,
                    contents: this.contents
                };

                this.$emit('passArticle', article);
            }
        }
    }
</script>