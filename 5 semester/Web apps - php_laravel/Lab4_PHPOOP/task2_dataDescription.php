<?php

interface InterfaceDescription {
    
    public function getDataDescription();
    public function generateDescription();
}

class Description implements InterfaceDescription {

    protected $header2="";
    protected $header3="";
    protected $image="";
    protected $paragraphArray=[]; 

    protected $object = null;

    public function getDataDescription()
    {
        return $this->header2;
    }
    public function setDataDescription()
    {
        $this->header2=$this->object->getHeader2();
        $this->header3=$this->object->getHeader3();
        $this->image=$this->object->getImage();
    }

    public function generateDescription() {
        $s="<h2>$this->header2</h2>\n";
        return $s;
    }

    public function __construct($ob)
    {
        $this->object=$ob;
        $this->setDataDescription();
    }

    public function getObject() {
        return $this->object;
    }

}

class QuickDescription extends Description {

    public function __construct($ob) {
        parent::__construct($ob);
    }

    public function setDataDescription()
    {
        parent::setDataDescription();
    }
    
    public function generateDescription() {
        $s="<div class=\"description_container\">";
        $s.="<div>";
        $s.="<h2>$this->header2</h2>\n";
        $s.="<h3>$this->header3</h3>\n";
        $s.="</div>";
        $s.="<div>";
        $s.="<img src=\"$this->image\" alt=\"$this->image\">";
        $s.="</div>";
        $s.="</div>";
        return $s;
    }   
}

class FullDescription extends Description {
    public function __construct($ob, ...$paragraphs) {
        parent::__construct($ob);
        $this->setDataDescription(...$paragraphs);
    }

    public function setDataDescription(...$paragraphs)
    {
        $this->paragraphArray = $paragraphs;
        parent::setDataDescription();
    }
    
    public function generateDescription() {
        
        $s="<div class=\"description_container\">";
        $s.="<div>";
        $s.="<h2>$this->header2</h2>\n";
        $s.="<h3>$this->header3</h3>\n";
        
        foreach($this->paragraphArray as $paragraph) { 
            $s.="<p>$paragraph</p>\n";
        }
        $s.="</div>";

        $s.="<div>";
        $s.="<img src=\"$this->image\" alt=\"$this->image\" style=\"max-width: 100%; height: auto;\">";
        $s.="</div>";
        $s.="</div>";
        return $s;
    }
}

class SmallNoteDescription extends Description {
    public function __construct($ob) {
        parent::__construct($ob);
    }

    public function setDataDescription()
    {
        parent::setDataDescription();
    }
    
    public function generateDescription() {
        $s="<div class=\"description_container\">";
        $s.="<div>";
        $s.="<h2>$this->header2</h2>\n";
        $s.="<h3>$this->header3</h3>\n";
        $s.="</div>";
        $s.="</div>";
        return $s;
    }
}

?>