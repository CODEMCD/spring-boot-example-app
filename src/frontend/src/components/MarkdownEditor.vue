<template>
    <div>
        <editor
                v-model="editorText"
                :value="editorText"
                :options="editorOptions"
                :html="editorHtml"
                :visible="editorVisible"
                previewStyle="vertical"
                height="500px"
                mode="wysiwyg"
        />
    </div>
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
            editorText: 'TEST',
            editorOptions: {
                hideModeSwitch: true
            },
            editorHtml: '',
            editorVisible: true,
        }),
    }
</script>