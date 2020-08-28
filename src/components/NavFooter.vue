<template>
    <div class="footer">
        <div class="footer-logo">
            <img src="/imgs/logo-footer.png" alt="">
            <p>美剧周边站</p>
        </div>
        <div class="footer-link">
            <a href="https://tablu666.github.io/" target="_blank">Blog</a><span>|</span>
            <a href="https://github.com/tablu666" target="_blank">GitHub</a><span>|</span>
            <a href="https://www.linkedin.com/in/tianbo-lu-230511104" target="_blank">LinkedIn</a><span>|</span>
            <a href="mailto:tablu666@outlook.com">E-mail</a>
        </div>
        <div class="copyright">© 2020<span class="heart"> ❤ </span>Tianbo Lu</div>
    </div>
</template>
<script>
    export default {
        name: 'nav-footer'
    }
</script>
<style lang="scss">
    @import "./../assets/scss/config.scss";

    .footer {
        height: 234px;
        border: 4px solid $colorA;
        background-color: #f6f9fa;
        color: $colorB;
        font-size: 16px;
        text-align: center;

        .footer-logo {
            margin-top: 46px;
            margin-bottom: 31px;

            img {
                height: 46px;
                margin-bottom: 13px;
            }
        }

        .footer-link {
            a {
                color: $colorB;
                display: inline-block;
            }

            span {
                margin: 0 10px;
            }

            margin-bottom: 13px;
        }

        .copyright {
            .heart {
                color: $colorA;
            }
        }
    }
</style>