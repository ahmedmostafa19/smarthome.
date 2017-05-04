<html>
    <% int [] arr = {1,2,3,4};
		String [] names= {"TV" , "Washing Maching", "TV 2", "Radio"};    
    %>
    
    <body>
	
      <form>
      <br>
	  `<% for(int i=0 ; i < arr.length ;i++) { %>
      <label> Device Name : <% out.print(names[i]); %> </label>
      <input type="radio" name="device" value="<% out.print(names[i]);%>">
	  <br>
	  <% }%>
	  <button type="submit">Confrim</button>
	  </form>
    </body>
  </html>