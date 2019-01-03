<html>
    <#include "../common/header.ftl">
    <body>
        <div id="wrapper" class="toggled">
            <#--边栏sidebar-->
            <#include "../common/nav.ftl">
            <#--主要内容content-->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th>商品id</th>
                                        <th>名称</th>
                                        <th>图片</th>
                                        <th>单价</th>
                                        <th>库存</th>
                                        <th>描述</th>
                                        <th>类目</th>
                                        <th>创建时间</th>
                                        <th>修改时间</th>
                                        <th colspan="2">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#list goodPage.content as good>
                                        <tr>
                                            <td>${good.id}</td>
                                            <td>${good.name}</td>
                                            <td>
                                                <#--<img height="100" width="100" src="${good.icon}" alt="">-->
                                            </td>
                                            <td>${good.price}</td>
                                            <td>${good.stock}</td>
                                            <td>${good.description}</td>
                                            <td>${good.categoryId}</td>
                                            <td>${good.createTime}</td>
                                            <td>${good.updateTime}</td>
                                            <td>
                                                <a href="/shop/sellerGood/indexSellerGood?id=${good.id}">修改</a>
                                            </td>
                                            <td>
                                                <#if good.getGoodStatusEnum().msg == "在架">
                                                    <a href="/shop/sellerGood/offSale?id=${good.id}">下架</a>
                                                <#else>
                                                    <a href="/shop/sellerGood/onSale?id=${good.id}" ><font color="#a9a9a9">上架</font></a>
                                                </#if>
                                            </td>
                                        </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>

                        <#--分页-->
                        <div class="col-md-12 column">
                            <ul class="pagination pull-right">
                                <#if currentPage lte 1>
                                    <li class="disabled"><a href="#">上一页</a></li>
                                <#else>
                                    <li><a href="/shop/sellerGood/listGoodByPage?page=${currentPage - 1}&size=${size}">上一页</a></li>
                                </#if>

                                <#list 1..goodPage.getTotalPages() as index>
                                    <#if currentPage == index>
                                        <li class="disabled"><a href="#">${index}</a></li>
                                    <#else>
                                        <li><a href="/shop/sellerGood/listGoodByPage?page=${index}&size=${size}">${index}</a></li>
                                    </#if>
                                </#list>

                                <#if currentPage gte goodPage.getTotalPages()>
                                    <li class="disabled"><a href="#">下一页</a></li>
                                <#else>
                                    <li><a href="/shop/sellerGood/listGoodByPage?page=${currentPage + 1}&size=${size}">下一页</a></li>
                                </#if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>