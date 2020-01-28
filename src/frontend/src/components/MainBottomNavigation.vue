<template>
    <div>
        <v-bottom-navigation
                v-model="bottomNav"
                grow
                absolute
        >
            <v-btn v-on:click="goHome">
                <span>홈</span>
                <v-icon>mdi-home</v-icon>
            </v-btn>

            <v-btn v-on:click="goWriteArticle">
                <span>글쓰기</span>
                <v-icon>mdi-pencil</v-icon>
            </v-btn>

            <v-btn v-on:click="goUserMenu">
                <span>내 정보</span>
                <v-icon>mdi-account</v-icon>
            </v-btn>
        </v-bottom-navigation>
    </div>
</template>

<script>
    export default {
        data: () => ({
            bottomNav: 'recent',
        }),
        methods: {
            goHome: function () {
                this.$router.push('/');
            },
            goWriteArticle: function () {
                this.$router.push('/articles/write');
            },
            goUserMenu: function () {
                // TODO: 로그인 전이면 '/login', 로그인 후이면 '/users/{userId}' 로 변경하기
                this.$router.push('/login');
            }
        }
    }
</script>