<template>
    <nav class="navbar navbar-light">
        <div class="container">
            <router-link class="navbar-brand" :to="{ name: 'home' }">
                CODEMCD-BOARD
            </router-link>
            <ul class="nav navbar-nav pull-xs-right">
                <li class="nav-item">
                    <router-link
                            class="nav-link"
                            active-class="active"
                            exact
                            :to="{ name: 'home' }"
                    >
                        Home
                    </router-link>
                </li>
                <li class="nav-item">
                    <router-link
                            class="nav-link"
                            active-class="active"
                            :to="{ name: 'writeArticle' }"
                    >
                        <i class="ion-compose"></i>&nbsp;New Article
                    </router-link>
                </li>
                <li class="nav-item">
                    <router-link
                            class="nav-link"
                            active-class="active"
                            exact
                            :to="{ name: 'settings' }"
                    >
                        <i class="ion-gear-a"></i>&nbsp;Settings
                    </router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
    export default {
        name: "RwvHeader",
        computed: {
        }
    };
</script>
