<style><%@include file="../../Layout/Header.css"%></style>
  

<div class="nav">
  <input type="checkbox" id="nav-check">
  <div class="nav-header">
    <div class="nav-title">
      Hotel Reservation
    </div>
  </div>
  <div class="nav-btn">
    <label for="nav-check">
      <span></span>
      <span></span>
      <span></span>
    </label>
  </div>
  
  <div class="nav-links">
    <a href="<%=request.getContextPath()%>/home">Home</a>
    <a href="<%=request.getContextPath()%>/MesReservation" >Mes Reservation</a>
    <a href="<%=request.getContextPath()%>/profile">Mon Profile</a>
    <a href="<%=request.getContextPath()%>/Logout">Logout</a>
  </div>
</div>
