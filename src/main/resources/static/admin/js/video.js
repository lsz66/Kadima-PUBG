var lsz = new Vue({
    el: "#video",
    data: {
        videoList: []
    },
    mounted: function () {
        $.get("/video", {}, function (data) {
            lsz.videoList = data;
        }, "JSON");
    },
    methods: {
        del: function (id) {
            layer.confirm("您确定要删除这个视频吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.ajax({
                        url: "/video",
                        data: {"id": id},
                        method: 'delete',
                        success: () => {
                            location.reload();
                        }
                    });
                });
        },
        showPath: function (path) {
            layer.alert("视频地址：<br/>" + path)
        }
    }
});
$(function () {
    $("#videoTable").DataTable({
        language: {url: "js/Chinese.json"},
        aoColumnDefs: [{"bSortable": false, "aTargets": [2, 5, 6]}]
    });
});