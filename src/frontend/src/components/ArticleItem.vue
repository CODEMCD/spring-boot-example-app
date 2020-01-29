<template>
    <v-list-item three-line link @click.stop="articleInfoDialog = true"
                 >
        <v-list-item-avatar
                size="80"
                class="mt-6"
        >
            <v-img :src="require('../assets/logo.png')"/>
        </v-list-item-avatar>
        <v-list-item-content class="py-0 ma-1">
            <v-divider/>
            <v-list-item-title>{{ article.title }}</v-list-item-title>
            <v-list-item-subtitle>{{ article.author }}</v-list-item-subtitle>
            <v-list-item-content>{{ article.contents }}</v-list-item-content>
        </v-list-item-content>
    </v-list-item>
</template>

<script>
    export default {
        props: ['article'],
        data: () => ({
        }),
    };
</script>