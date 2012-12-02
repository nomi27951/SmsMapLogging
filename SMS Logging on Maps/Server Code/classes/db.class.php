<?PHP
class DB_MySql {

  var $link_id = 0;
  var $query_id = 0;
  var $record   = array();
  var $errdesc    = "";
  var $errno   = 0;
  var $reporterror = 1;  
  var $appname;
  var $appshortname;
  var $technicalemail;

  function connect() {
    global $usepconnect;
    // connect to db server

    if ( 0 == $this->link_id ) {
      if ($this->password=="") {
        if ($usepconnect==1) {
          $this->link_id=mysql_pconnect($this->server,$this->user);
        } else {
          $this->link_id=mysql_connect($this->server,$this->user);
        }
      } else {
        if ($usepconnect==1) {
          $this->link_id=mysql_pconnect($this->server,$this->user,$this->password, true);
        } else {
          $this->link_id=mysql_connect($this->server,$this->user,$this->password, true);
        }
      }
      if (!$this->link_id) {
        $this->halt("Link-ID == false, connect failed");
      }
      if ($this->database!="") {
        if(!mysql_select_db($this->database, $this->link_id)) {
          $this->halt("cannot use database ".$this->database);
        }
      }
    }
  }

  function close() {
     mysql_close($this->link_id);
  }

  function geterrdesc() {
    $this->error=mysql_error();
    return $this->error;
  }

  function geterrno() {
    $this->errno=mysql_errno();
    return $this->errno;
  }

  function select_db($database="") {
    // select database
    if ($database!="") {
      $this->database=$database;
    }

    if(!mysql_select_db($this->database, $this->link_id)) {
      $this->halt("cannot use database ".$this->database);
    }

  }

  function query($query_string, $show_error = true) {
    global $query_count,$showqueries,$explain,$querytime;
    $this->query_id = mysql_query($query_string,$this->link_id);
    if (!$this->query_id && $show_error) {
      $this->halt("Invalid SQL: ".$query_string);
    }

    $query_count++;
  
    return $this->query_id;
  }
  
 

  function fetch_array($query_id=-1,$query_string="") {
    // retrieve row
    if ($query_id!=-1) {
      $this->query_id=$query_id;
    }
    if ( isset($this->query_id) ) {
      $this->record = mysql_fetch_array($this->query_id);
    } else {
      if ( !empty($query_string) ) {
        $this->halt("Invalid query id (".$this->query_id.") on this query: $query_string");
      } else {
        $this->halt("Invalid query id ".$this->query_id." specified");
      }
    }

    return $this->record;
  }
  
  function fetch_object($query_id=-1,$query_string="") {
    // retrieve row
    if ($query_id!=-1) {
      $this->query_id=$query_id;
    }
    if ( isset($this->query_id) ) {
      $this->record = mysql_fetch_object($this->query_id);
    } else {
      if ( !empty($query_string) ) {
        $this->halt("Invalid query id (".$this->query_id.") on this query: $query_string");
      } else {
        $this->halt("Invalid query id ".$this->query_id." specified");
      }
    }

    return $this->record;
  }

  function free_result($query_id=-1) {
    // retrieve row
    if ($query_id!=-1) {
      $this->query_id=$query_id;
    }
    //return @mysql_free_result($this->query_id);
  }

  function query_first($query_string) {
    // does a query and returns first row
    $query_id = $this->query($query_string);
    $returnarray=$this->fetch_array($query_id, $query_string);
    $this->free_result($query_id);
    return $returnarray;
  }

  function data_seek($pos,$query_id=-1) {
    // goes to row $pos
    if ($query_id!=-1) {
      $this->query_id=$query_id;
    }
    return mysql_data_seek($this->query_id, $pos);
  }

  function num_rows($query_id=-1) {
    // returns number of rows in query
    if ($query_id!=-1) {
      $this->query_id=$query_id;
    }
    return mysql_num_rows($this->query_id);
  }
  
  function num_fields($query_id=-1) {
    // returns number of fields in query
    if ($query_id!=-1) {
      $this->query_id=$query_id;
    }
    return mysql_num_fields($this->query_id);
  }

  function insert_id() {
    // returns last auto_increment field number assigned

    return mysql_insert_id($this->link_id);

  }

  function halt($msg = 0, $discription = 0) {
    $this->errdesc=mysql_error();
    $this->errno=mysql_errno();
    // prints warning message when there is an error

    if ($this->reporterror==1) {
	
	
		$message="mysql error: $this->errdesc <BR>";
		$message.="mysql error number: $this->errno <BR>";
		$message.="mysql error discription: <b>$discription</b> <BR>";	  	
		$message.="Database error in $this->appname: <b>$msg</b> <BR>";
		$message.="Date: ".date("l dS of F Y h:i:s A")." <BR>";
		$message.="Script: <a href=\"$_SERVER[HTTP_HOST]$_SERVER[REQUEST_URI]\">$_SERVER[HTTP_HOST]$_SERVER[REQUEST_URI]</a> <BR>";
		$message.="Referer: <a href=\"$_SERVER[HTTP_REFERER]\">$_SERVER[HTTP_REFERER]</a> <BR>";
	  
		$headers  = "MIME-Version: 1.0\r\n";
		$headers .= "Content-type: text/html; charset=iso-8859-1\r\n";
		$headers .= "From: info@SoftwareError.com\r\n";	  
		//mail("$this->technicalemail", "MovingDay.com Tech Support " , $message, $headers);
		


      if ($discription) { echo "<B><font color=\"#FF0000\">$discription </font></b><BR><BR>"; }
      echo "<B>There seems to have been a slight problem with the database.</b><BR>";
      echo "An E-Mail has been dispatched to our <a href=\"mailto: info@adirnet.com\">Technical Staff</a>, who you can also contact if the problem persists.<BR>";
      echo "We apologize for any inconvenience. <BR>";
	  echo "<BR><BR>$message";
	  if ($Access == '0') { echo $message; }
      
      die("");
    }
	
  }
}  
?>