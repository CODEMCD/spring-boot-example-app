<template>
    <div class="editor-page">
        <div class="container page">
            <div class="row">
                <div class="col-md-10 offset-md-1 col-xs-12">
                    <form @submit.prevent="requestSaveArticle()">
                        <fieldset class="form-group">
                            <input
                                    type="text"
                                    class="form-control form-control-lg"
                                    v-model="title"
                                    placeholder="Article Title"
                            />
                        </fieldset>
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
                        <button
                                class="btn btn-lg pull-xs-right btn-primary"
                                type="submit"
                        >
                            Publish Article
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import 'tui-editor/dist/tui-editor.css';
    import 'tui-editor/dist/tui-editor-contents.css';
    import 'codemirror/lib/codemirror.css';
    import Editor from '@toast-ui/vue-editor/src/Editor.vue'

    export default {
        name: 'RwvArticleEdit',
        components: {
            Editor,
        },
        data: () => ({
            title: '',
            contents: '',
            editorOptions: {
                hideModeSwitch: true
            },
            editorHtml: '',
            editorVisible: true,
        }),
        methods: {
            requestSaveArticle: function () {
                const articleRequestDto = {
                    author: "park",
                    title: this.title,
                    contents: this.contents
                };

                const currentVue = this;
                axios.post('/api/articles', articleRequestDto).then(function (response) {
                    console.log(response);
                    if (response.status === 200) {
                        currentVue.$router.push('/');
                    }
                }).catch(function (error) {
                    console.log(error);
                })
            }
        }
    };
</script>
