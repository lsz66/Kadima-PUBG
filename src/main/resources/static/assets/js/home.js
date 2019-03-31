var lsz = new Vue({
    el: "#lsz",
    data: {
        videoList: []
    },
    mounted: function () {
        $.ajax({
            type: "get",
            url: "video",
            dataType: "JSON",
            success: function (data) {
                lsz.videoList = data;
            },
            error: function () {
                layer.confirm("无法获取后台数据，可能您还没有部署数据库，现在是否要部署数据库？", {
                    btn: ["好der", "不了不了"]
                }, function () {
                    location.href = "db-init.html"
                });
            }
        })
    },
    methods: {
        showVideo: function (index) {
            layer.open({
                type: lsz.videoList[index].type,
                title: false,
                area: ['1200px', '800px'],
                shade: 0.8,
                closeBtn: 0,
                shadeClose: true,
                content: lsz.videoList[index].path
            });
        }
    }
});