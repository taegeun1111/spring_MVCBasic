<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>

            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Single+Day&display=swap" rel="stylesheet">

            <!-- reset -->
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

            <!-- fontawesome css: https://fontawesome.com -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">

            <link rel="stylesheet" href="/assets/css/main.css">
            <link rel="stylesheet" href="/assets/css/list2.css">

        </head>

        <body>

            <div id="wrap">

                <div class="main-title-wrapper">
                    <h1 class="main-title">꾸러기 게시판</h1>
                    <button class="add-btn">새 글 쓰기</button>
                </div>

                <!-- <form action="/board/detail" method="get"> -->
                <div class="card-container">
                    <c:forEach var="b" items="${blist}">
                        <div class="card-wrapper" onClick="location.href='/board/detail?boardNo=${b.boardNo}'">
                            <input type="hidden" name="boardNo" value="${b.boardNo}">
                            <section class="card">
                                <div class="card-title-wrapper">
                                    <h2 class="card-title">${b.shortTitle}</h2>
                                    <div class="time-view-wrapper">
                                        <div class="time"><i class="far fa-clock"></i>${b.date}</div>
                                        <div class="view">
                                            <i class="fas fa-eye"></i>
                                            <span class="view-count">${b.viewCount}</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-content">
                                    <p>
                                        ${b.shortContent}
                                    </p>
                                </div>
                            </section>

                            <a href="/board/delete?boardNo=${b.boardNo}">
                                <input type="hidden" name="boardNo" value="${b.boardNo}">
                                <div class="card-btn-group">
                                    <button class="del-btn">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                    <!-- </form> -->


                </div>
                
                <div class="modal" id="modal">
                    <div class="modal-content">
                        <p>정말로 삭제할까요?</p>
                        <div class="modal-buttons">
                            <button class="confirm" id="confirmDelete"><i class="fas fa-check"></i> 예</button>
                            <button class="cancel" id="cancelDelete"><i class="fas fa-times"></i> 아니오</button>   
                        </div>
                    </div>
                </div>

            </div>



            <script>
                
                //삭제버튼 스크립트
                const $modal = document.getElementById('modal'); //모달창 열기
                const $confrimDelete = document.getElementById('confirmDelete'); //확인버튼
                const $cancelDelete = document.getElementById('cancelDelete'); //취소 버튼

                $cardContainer.addEventListener('click', e => {
                    if(e.target.matches('.card-btn-group *')){ //안에 태그가 많기 때문에
                        console.log("삭제버튼 클릭");
                        modal.style.display = flex;

                        const $delBtn = e.target.closest('.del-btn');
                    }
                })




                function removeDown(e) {
                    if (!e.target.matches('.card-container *')) return;
                    const $targetCard = e.target.closest('.card-wrapper');
                    $targetCard?.removeAttribute('id', 'card-down');
                }

                function removeHover(e) {
                    if (!e.target.matches('.card-container *')) return;
                    const $targetCard = e.target.closest('.card');
                    $targetCard?.classList.remove('card-hover');

                    const $delBtn = e.target.closest('.card-wrapper') ?.querySelector('.del-btn');
                    $delBtn.style.opacity = '0';
                }

                const $cardContainer = document.querySelector('.card-container');

                $cardContainer.onmouseover = e => {

                    if (!e.target.matches('.card-container *')) return;

                    const $targetCard = e.target.closest('.card');
                    $targetCard?.classList.add('card-hover');

                    const $delBtn = e.target.closest('.card-wrapper') ?.querySelector('.del-btn');
                    $delBtn.style.opacity = '1';
                }

                $cardContainer.onmousedown = e => {

                    if (!e.target.matches('.card-container *')) return;

                    const $targetCard = e.target.closest('.card-wrapper');
                    $targetCard?.setAttribute('id', 'card-down');
                };

                $cardContainer.onmouseup = removeDown;

                $cardContainer.addEventListener('mouseout', removeDown);
                $cardContainer.addEventListener('mouseout', removeHover);

                // write button event
                document.querySelector('.add-btn').onclick = e => {
                    window.location.href = '/board/write';
                };
            </script>

        </body>

        </html>