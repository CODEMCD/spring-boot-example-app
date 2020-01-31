<template>
    <div class="home-page">
        <div class="banner">
            <div class="container">
                <h1 class="logo-font">conduit</h1>
                <p>A place to share your knowledge.</p>
            </div>
        </div>
        <div class="container page">
            <div class="row">
                <div class="col-md-9">
                    <div class="feed-toggle">
                        <ul class="nav nav-pills outline-active">
                            <li class="nav-item">
                                <router-link
                                        :to="{ name: 'home' }"
                                        exact
                                        class="nav-link"
                                        active-class="active"
                                >
                                    Global Feed
                                </router-link>
                            </li>
                        </ul>
                    </div>
                    <router-view></router-view>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "home",
        components: {
        },
        mounted() {
        },
        computed: {
        }
    };
</script>
