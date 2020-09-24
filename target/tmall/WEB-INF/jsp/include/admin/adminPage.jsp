<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    $(function(){
        $("ul.pagination li.disabled a").click(function(){
            return false;
        });
    });

</script>

<nav style="text-align: center;">
    <ul class="pagination">
        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
            <a  href="?strat=0${page.param}" aria-label="Previous" >
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>

        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
            <a  href="?strat=${page.strat-page.count}${page.param}" aria-label="Previous" >
                <span aria-hidden="true">&lsaquo;</span>
            </a>
        </li>

        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
            <li <c:if test="${status.index*page.count==page.strat}">class="disabled"</c:if>>
                <a
                        href="?strat=${status.index*page.count}${page.param}"
                        <c:if test="${status.index*page.count==page.strat}">class="current"</c:if>
                >${status.count}</a>
            </li>
        </c:forEach>

        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="?strat=${page.strat+page.count}${page.param}" aria-label="Next">
                <span aria-hidden="true">&rsaquo;</span>
            </a>
        </li>
        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="?strat=${page.last}${page.param}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>