<template>
    <div>
        <v-card
                v-for="article in articles"
                :key="article.id"
                class="mx-auto mb-5"
                max-width="90%"
                outlined
        >
            <ArticleItem v-bind:article="article"/>
        </v-card>
    </div>
</template>

<script>
    import ArticleItem from './ArticleItem.vue';

    export default {
        components: {
            ArticleItem,
        },
        props: ['articles'],
        data: () => ({
        }),
    };
</script>