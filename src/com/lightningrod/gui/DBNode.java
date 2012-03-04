



  



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head><script type="text/javascript">var NREUMQ=NREUMQ||[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
    <title>src/com/lightningrod/gui/DBNode.java | Source/Git | Assembla</title>
    <link href="https://assets2.assembla.com/favicon.ico?1327583367" type="image/x-icon" rel="shortcut icon" />
    <link href="https://assets2.assembla.com/favicon.ico?1327583367" type="image/x-icon" rel="icon" />
    <link href="https://assets1.assembla.com/favicon.gif?1327583367" type="image/gif" rel="icon" />
    <meta name="csrf-param" content="authenticity_token"/>
<meta name="csrf-token" content="Mc1xu0S6naz8TMG7QoH4U6rGtAMmJdSFZfioIY8ynv4="/>
    <link href="https://www.assembla.com/assets/base_app_and_alerts.css?1330708843" media="all" rel="stylesheet" type="text/css" />
    
    
    <link href="https://www.assembla.com/assets/code.css?1330708843" media="all" rel="stylesheet" type="text/css" />  

    
    <!--[if IE 7]>
      <link href="https://www.assembla.com/assets/ie7.css?1330708843" media="all" rel="stylesheet" type="text/css" />
    <![endif]-->
    <!--[if lte IE 8]>
      <link href="https://www.assembla.com/assets/ie8.css?1330708843" media="all" rel="stylesheet" type="text/css" />
    <![endif]-->
    <link href="https://www.assembla.com/assets/print.css?1330708843" media="print" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
      if(!Breakout){var Breakout = {};}
          Breakout.space_wiki_name = "lightningrod";
          Breakout.space_id = "da_Q_WzzGr4B5RacwqjQXA";
        Breakout.user_id = "a-EdYcstSr4BrDacwqjQYw";
        Breakout.controller_name = "spaces/nodes"
        Breakout.action_name = "show"
    </script>
    
    <script src="https://www.assembla.com/assets/base.js?1330708890" type="text/javascript"></script>
    <script src="https://www.assembla.com/assets/code.js?1330708843" type="text/javascript"></script>
    
    
      

      
  
    <meta name="ROBOTS" content="NOINDEX">
  


    <!-- prevents swf file caching -->
    <meta http-equiv="PRAGMA" content="NO-CACHE" />
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    
  </head>

  <body class="locale_en" data-locale="en">
    
    <!--[if IE 6]>
      <div class="browser-ie6" style="display: none;"><div>
    <![endif]-->
    <div class="b-wrapper">
      <a name="pagetop"></a>
        <script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-2641193-1']);
    _gaq.push(['_setDomainName', 'assembla.com']);
    _gaq.push(['_setCustomVar', 1, 'Logged', 'true', 1]);
    
    _gaq.push(['_trackPageview']);

    (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ga);
    })();
  
  </script>


      <div class="hidden">
        <a href="#content">Skip to contents</a>
      </div>

      
          <div class="app-top-bar-spacer"></div>
  
  <div class="app-top-bar" id="header">
    <div class="left-app-top-bar">
      <ul>
          <li class=" home">
            <a href="/home" title="Go to Assembla">Assembla</a>
          </li>
          <li class=" start">
            <a href="/start">My Start</a>
          </li>

          <li class="">
            <a href="https://www.assembla.com/spaces/show/cis_542">CIS_542</a>
          </li>
          <li class="">
            <a href="https://www.assembla.com/spaces/show/cis542">cis542</a>
          </li>

          <li class="selected">
            <a href="https://www.assembla.com/spaces/show/lightningrod">lightningrod</a>
          </li>

          <li class="">
            <a href="#" id="more_spaces_link">More Spaces ▼</a>
            <div id="top-more-spaces">
              <ul>
                  <li><a href="https://www.assembla.com/spaces/show/pre-fire-mapping">Pre-Fire-Mapping</a></li>
              </ul>
            </div>
          </li>

      </ul>
    </div><!-- /left-app-top-bar -->

    <div class="right-app-top-bar">
      <div class="user-options" id="user-options">
        <div class="dropdown-wraper">
          <a class="dropdown-link" href="#">
            <span class="user-pic"><img alt="User picture" src="https://assets2.assembla.com/images/no-picture-hover-small.png?1330708843" /></span>
            <span class="user-name">BillVT</span>
          </a>
        </div>

        <div id="user-links">
          <ul>
            <li><a href="/user/edit">Edit Profile</a></li>
              <li><a href="/account">Account</a></li>
            <li><a href="/logout">Logout</a></li>
          </ul>
        </div><!-- /user-links -->
      </div><!-- /user-options -->

    </div><!-- /right-app-top-bar -->

  </div>



<div id="header-w">
  <div id="header" class="_">
    <div id="header-links">
      <div class="top-space"><span id="space-role">Free/Private Space <span>|</span> Member</span></div>
    </div>
    <div id="logo">
      <div  id="space-customlogo" class="space-customlogo-sideborder" >
          <h1 class="header-w clear-float">
            <span>lightningrod</span>
          </h1>

            

      </div>
    </div>


    <div class="cut">&nbsp;</div>

  </div><!-- /header -->
</div><!-- /header-w -->


      
      <div id="main-menu-w">
        <ul class='clear-float' id='main-menu'><li class="current"><a href="/code/lightningrod/git/nodes">Source/Git</a></li><li class=""><a href="/spaces/lightningrod/stream">Stream</a></li><li class=""><a href="/spaces/lightningrod/team">Team</a></li><li class="grayed-out"><a href="/spaces/lightningrod/additional_tools">Additional Tools</a></li><li class="search-field"><form accept-charset="UTF-8" action="/spaces/lightningrod/search" id="search-form" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div><input id="object_scope_top_right" name="object_scope" type="hidden" value="10" />
<input class="main-search" id="q" name="q" onfocus="this.value == 'Search this space' ? this.value = '' : true" size="15" type="text" value="Search this space" />
</form></li></ul>
      </div><!-- /main-menu-w -->

      <ul class='menu-submenu'><li><a href="/code/lightningrod/git/nodes" class="first selected">Browse</a></li><li><a href="/code/lightningrod/git/changesets" class="">Changesets</a></li><li><a href="/code/lightningrod/git/reviews" class="">Review Code</a></li><li><a href="/code/lightningrod/git/merge_requests" class="">Contribute Code</a></li><li><a href="/code/lightningrod/git/forks" class="">Fork Network</a></li><li><a href="/code/lightningrod/git/sites" class="">Sites</a></li><li><a href="/code/lightningrod/git/repo/instructions" class=" last">Instructions</a></li></ul><div class='cut'></div>

      

      <div id="content" >
        
        
          <div class="repository-browser">
  <h1 class="icon-breadcrumb-path"><a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1" class="root">d4dfb28694</a>/<a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src">src</a>/<a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com">com</a>/<a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod">lightningrod</a>/<a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod/gui">gui</a>/<span>DBNode.java</span><span>    <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
            width="110"
            height="14"
            id="clippy" >
    <param name="movie" value="/clippy.swf"/>
    <param name="allowScriptAccess" value="always" />
    <param name="quality" value="high" />
    <param name="scale" value="noscale" />
    <param NAME="FlashVars" value="text=git@git.assembla.com:lightningrod.git/src/com/lightningrod/gui/DBNode.java/" />
    <param name="bgcolor" value="#FFFFFF" />
    <param name="wmode" value="transparent" />
    <embed src="/clippy.swf"
           width="110"
           height="14"
           name="clippy"
           quality="high"
           allowScriptAccess="always"
           type="application/x-shockwave-flash"
           pluginspage="http://www.macromedia.com/go/getflashplayer"
           FlashVars="text=git@git.assembla.com:lightningrod.git/src/com/lightningrod/gui/DBNode.java/"
           bgcolor="#FFFFFF"
           wmode="transparent"
    />
    </object>
</span></h1>
  
<div class="commit-infobox">
  <div class="commit-options">
    <a href="/code/lightningrod/git/node/logs/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod/gui/DBNode.java" class="revision-log" rel="nofollow">Revision log</a>
      <div style="margin-right: 10px;" class="small-icon-button">
        <a href="/code/lightningrod/git/node/live/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod/gui/DBNode.java" class="view-icon" rel="nofollow">View as a web page</a>
      </div>

        <div style="margin-right: 10px;" class="small-icon-button">
    <a class="download-icon" href="#" onclick="nobotGoto('!/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod/gui/DBNode.java?_format=raw'); return false;">Download</a>
  </div>


  </div>

  <div class="committer-pic">
    <img alt="User picture" src="https://assets0.assembla.com/images/no-picture-hover.png?1330708843" />
  </div>

  
<div class="commit-info">
    <p class="committer-info"><span>Commiter:</span> <a href="/profile/BillVT" tabindex="-1" target="_blank" title="Show Profile">BillVT</a></p>

    <p class="committer-info"><span>Author:</span> <a href="/profile/BillVT" tabindex="-1" target="_blank" title="Show Profile">BillVT</a></p>

  <p class="committer-info"><span>Revision:</span> <a href="/code/lightningrod/git/changesets/d4dfb28694c326075834d9e9ad04d6e05630d5c1">d4dfb28694</a> </p><br />
    <p class="commit-size">
      <span>File Size:</span>
      4 KB
    </p>
  <p class="commit-date">(04 Mar 06:09) 23 minutes ago</p>
</div>



  <p class="commit-description">
    <pre>About to start second major file gui fix</pre>
  </p>
</div>

<div class="cut">&nbsp;</div>




      <a href="#" onclick="$(&quot;ln-num&quot;).toggle(); return false;">Show/hide line numbers</a>

      <table class="ln-code">
        <tbody class="full-width">
          <tr>
            <th id="ln-num" style="display: none;">
              <pre><a href="#ln1" class="block" id="ln1">1</a>
<a href="#ln2" class="block" id="ln2">2</a>
<a href="#ln3" class="block" id="ln3">3</a>
<a href="#ln4" class="block" id="ln4">4</a>
<a href="#ln5" class="block" id="ln5">5</a>
<a href="#ln6" class="block" id="ln6">6</a>
<a href="#ln7" class="block" id="ln7">7</a>
<a href="#ln8" class="block" id="ln8">8</a>
<a href="#ln9" class="block" id="ln9">9</a>
<a href="#ln10" class="block" id="ln10">10</a>
<a href="#ln11" class="block" id="ln11">11</a>
<a href="#ln12" class="block" id="ln12">12</a>
<a href="#ln13" class="block" id="ln13">13</a>
<a href="#ln14" class="block" id="ln14">14</a>
<a href="#ln15" class="block" id="ln15">15</a>
<a href="#ln16" class="block" id="ln16">16</a>
<a href="#ln17" class="block" id="ln17">17</a>
<a href="#ln18" class="block" id="ln18">18</a>
<a href="#ln19" class="block" id="ln19">19</a>
<a href="#ln20" class="block" id="ln20">20</a>
<a href="#ln21" class="block" id="ln21">21</a>
<a href="#ln22" class="block" id="ln22">22</a>
<a href="#ln23" class="block" id="ln23">23</a>
<a href="#ln24" class="block" id="ln24">24</a>
<a href="#ln25" class="block" id="ln25">25</a>
<a href="#ln26" class="block" id="ln26">26</a>
<a href="#ln27" class="block" id="ln27">27</a>
<a href="#ln28" class="block" id="ln28">28</a>
<a href="#ln29" class="block" id="ln29">29</a>
<a href="#ln30" class="block" id="ln30">30</a>
<a href="#ln31" class="block" id="ln31">31</a>
<a href="#ln32" class="block" id="ln32">32</a>
<a href="#ln33" class="block" id="ln33">33</a>
<a href="#ln34" class="block" id="ln34">34</a>
<a href="#ln35" class="block" id="ln35">35</a>
<a href="#ln36" class="block" id="ln36">36</a>
<a href="#ln37" class="block" id="ln37">37</a>
<a href="#ln38" class="block" id="ln38">38</a>
<a href="#ln39" class="block" id="ln39">39</a>
<a href="#ln40" class="block" id="ln40">40</a>
<a href="#ln41" class="block" id="ln41">41</a>
<a href="#ln42" class="block" id="ln42">42</a>
<a href="#ln43" class="block" id="ln43">43</a>
<a href="#ln44" class="block" id="ln44">44</a>
<a href="#ln45" class="block" id="ln45">45</a>
<a href="#ln46" class="block" id="ln46">46</a>
<a href="#ln47" class="block" id="ln47">47</a>
<a href="#ln48" class="block" id="ln48">48</a>
<a href="#ln49" class="block" id="ln49">49</a>
<a href="#ln50" class="block" id="ln50">50</a>
<a href="#ln51" class="block" id="ln51">51</a>
<a href="#ln52" class="block" id="ln52">52</a>
<a href="#ln53" class="block" id="ln53">53</a>
<a href="#ln54" class="block" id="ln54">54</a>
<a href="#ln55" class="block" id="ln55">55</a>
<a href="#ln56" class="block" id="ln56">56</a>
<a href="#ln57" class="block" id="ln57">57</a>
<a href="#ln58" class="block" id="ln58">58</a>
<a href="#ln59" class="block" id="ln59">59</a>
<a href="#ln60" class="block" id="ln60">60</a>
<a href="#ln61" class="block" id="ln61">61</a>
<a href="#ln62" class="block" id="ln62">62</a>
<a href="#ln63" class="block" id="ln63">63</a>
<a href="#ln64" class="block" id="ln64">64</a>
<a href="#ln65" class="block" id="ln65">65</a>
<a href="#ln66" class="block" id="ln66">66</a>
<a href="#ln67" class="block" id="ln67">67</a>
<a href="#ln68" class="block" id="ln68">68</a>
<a href="#ln69" class="block" id="ln69">69</a>
<a href="#ln70" class="block" id="ln70">70</a>
<a href="#ln71" class="block" id="ln71">71</a>
<a href="#ln72" class="block" id="ln72">72</a>
<a href="#ln73" class="block" id="ln73">73</a>
<a href="#ln74" class="block" id="ln74">74</a>
<a href="#ln75" class="block" id="ln75">75</a>
<a href="#ln76" class="block" id="ln76">76</a>
<a href="#ln77" class="block" id="ln77">77</a>
<a href="#ln78" class="block" id="ln78">78</a>
<a href="#ln79" class="block" id="ln79">79</a>
<a href="#ln80" class="block" id="ln80">80</a>
<a href="#ln81" class="block" id="ln81">81</a>
<a href="#ln82" class="block" id="ln82">82</a>
<a href="#ln83" class="block" id="ln83">83</a>
<a href="#ln84" class="block" id="ln84">84</a>
<a href="#ln85" class="block" id="ln85">85</a>
<a href="#ln86" class="block" id="ln86">86</a>
<a href="#ln87" class="block" id="ln87">87</a>
<a href="#ln88" class="block" id="ln88">88</a>
<a href="#ln89" class="block" id="ln89">89</a>
<a href="#ln90" class="block" id="ln90">90</a>
<a href="#ln91" class="block" id="ln91">91</a>
<a href="#ln92" class="block" id="ln92">92</a>
<a href="#ln93" class="block" id="ln93">93</a>
<a href="#ln94" class="block" id="ln94">94</a>
<a href="#ln95" class="block" id="ln95">95</a>
<a href="#ln96" class="block" id="ln96">96</a>
<a href="#ln97" class="block" id="ln97">97</a>
<a href="#ln98" class="block" id="ln98">98</a>
<a href="#ln99" class="block" id="ln99">99</a>
<a href="#ln100" class="block" id="ln100">100</a>
<a href="#ln101" class="block" id="ln101">101</a>
<a href="#ln102" class="block" id="ln102">102</a>
<a href="#ln103" class="block" id="ln103">103</a>
<a href="#ln104" class="block" id="ln104">104</a>
<a href="#ln105" class="block" id="ln105">105</a>
<a href="#ln106" class="block" id="ln106">106</a>
<a href="#ln107" class="block" id="ln107">107</a>
<a href="#ln108" class="block" id="ln108">108</a>
<a href="#ln109" class="block" id="ln109">109</a>
<a href="#ln110" class="block" id="ln110">110</a>
<a href="#ln111" class="block" id="ln111">111</a>
<a href="#ln112" class="block" id="ln112">112</a>
<a href="#ln113" class="block" id="ln113">113</a>
<a href="#ln114" class="block" id="ln114">114</a>
<a href="#ln115" class="block" id="ln115">115</a>
<a href="#ln116" class="block" id="ln116">116</a>
<a href="#ln117" class="block" id="ln117">117</a>
<a href="#ln118" class="block" id="ln118">118</a>
<a href="#ln119" class="block" id="ln119">119</a>
<a href="#ln120" class="block" id="ln120">120</a>
<a href="#ln121" class="block" id="ln121">121</a>
<a href="#ln122" class="block" id="ln122">122</a>
<a href="#ln123" class="block" id="ln123">123</a>
<a href="#ln124" class="block" id="ln124">124</a>
<a href="#ln125" class="block" id="ln125">125</a>
<a href="#ln126" class="block" id="ln126">126</a>
<a href="#ln127" class="block" id="ln127">127</a>
<a href="#ln128" class="block" id="ln128">128</a>
<a href="#ln129" class="block" id="ln129">129</a>
<a href="#ln130" class="block" id="ln130">130</a>
<a href="#ln131" class="block" id="ln131">131</a>
<a href="#ln132" class="block" id="ln132">132</a>
<a href="#ln133" class="block" id="ln133">133</a>
<a href="#ln134" class="block" id="ln134">134</a>
<a href="#ln135" class="block" id="ln135">135</a></pre></th>
            <td><pre class="prettyprint lang-java">/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningrod.gui;

import com.dropbox.client2.DropboxAPI;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 * A class that defines a Node in the DropBox File Structure
 * The node object is the DropBox Entry Object
 * @author William Etter
 */
class DBNode extends DefaultMutableTreeNode {
    // &lt;editor-fold&gt;
    protected boolean isDirectory;  // Is the node a Directory?
    protected boolean isSelected;   // Is the node selected?    
    
    /*
     ********** CONSTRUCTORS ************
    */
    public DBNode() {
        // Should only go here when creating the root node
        super(null,true);
    }

    public DBNode(Object dbEntry) {
        super(dbEntry,((DropboxAPI.Entry)dbEntry).isDir);
        
        DropboxAPI.Entry entry = (DropboxAPI.Entry)dbEntry;
    }
    
    /*
     * ONLY USED FOR TESTING
     */
    public DBNode(Object dbEntry, boolean direct) {
        super(dbEntry,direct);
        DropboxAPI.Entry entry = (DropboxAPI.Entry)dbEntry;
    }
    
    /*
     * Override add method to allow for sorting of files/folders
     */
    @Override
    public void add(MutableTreeNode newChild) {
        super.add(newChild);
        Collections.sort(this.children, nodeComparator);
        
        // Determine if parent is selected
        if(this.isSelected()){
            // Set child as selected
            ((DBNode)newChild).setSelected(true);
        }      
    }

    /*
    *   Set the node selection.  If a directory, set all children as selected
    *   recursively.
    */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        if (children != null) {
            Enumeration e = children.elements();
            while (e.hasMoreElements()) {
                DBNode node = (DBNode) e.nextElement();
                node.setSelected(isSelected);
            }
        }
    }
    
    /*
    *   Returns whether the node is selected or not.
    */
    public boolean isSelected() {
        return isSelected;
    }
    
    /*
     *  Returns whether the node allows children or not.
     */
    public boolean childrenAllowed(){
        return this.allowsChildren;
    }
    
    
    /*
    *   Overrides the DefaultMutableTreeNode toString method for use when
    *   displaying file structure
    */
    @Override
    public String toString(){
        if((DropboxAPI.Entry)this.getUserObject() == null){
            return &quot;Need to Sync with DropBox Server&quot;;
        }
        else{
            return ((DropboxAPI.Entry)this.getUserObject()).fileName();
        }
    }
    
    protected Comparator nodeComparator = new Comparator () {
        @Override
        public int compare(Object o1, Object o2) {
            // Check object values
            if(((DBNode)o1).childrenAllowed()){ 
            //if(((DropboxAPI.Entry)(((DBNode)o1).getUserObject())).isDir){ -PUT BACK IN AFTER TESTING
                //if(((DropboxAPI.Entry)o1).isDir){
                if(((DBNode)o2).childrenAllowed()){
                    // o1 directory and o2 directory
                    return o1.toString().compareToIgnoreCase(o2.toString());
                }
                else{
                    // o1 directory and o2 file -&gt; file first
                    return -1;
                }
            }else{
                if(((DBNode)o2).childrenAllowed()){
                //if(((DBNode)o2).childrenAllowed()){
                //if(((DropboxAPI.Entry)(((DBNode)o2).getUserObject())).isDir){ - PUT BACK IN AFTER TESTING
                    // o1 file and o2 directory -&gt; file first
                    return 1;
                }
                else{
                    // o1 file and o2 file
                    return o1.toString().compareToIgnoreCase(o2.toString());
                }
            }
        }
    };
    // &lt;/editor-fold&gt;
}   // END CLASS DBnode</pre></td>
          </tr>
        </tbody>
      </table>
</div>

<script type="text/javascript">
//<![CDATA[
if (window.location.href.split("#").length != 1) { $("ln-num").show(); }
//]]>
</script>

  <script type="text/javascript">
//<![CDATA[
prettyPrint()
//]]>
</script>


      </div><!-- /content -->

        

      <div class="push-app"></div>
    </div><!-- /b-wrapper -->

    <div class="cut">&nbsp;</div>
      <div id="footer-w">
  <div class="tutorial-and-bookmark">
      
  </div>

  

  <div id="footer">

    <p>
      <a href="/">Home</a>
      / <a href="/community">Community</a>
      / <a href="http://www.assembla.com/wiki/show/c8A2BGQEWr2RUvaaeP0Qfc">Documentation</a>
        / <a href="http://forum.assembla.com/" target="_blank">Report bugs</a>
        / <a href="http://feedback.assembla.com/" target="_blank">Send us Suggestions</a>
        / <a href="/spaces/lightningrod/prepare_copy">Copy this space</a>
    </p>

      <p>
        
      </p>

    <p id="copyr-contact">
    Lightningrod is powered by Assembla Workspaces. <a href="/">Learn More</a>
</p>

  </div><!-- /footer -->
</div><!-- /footer-w -->



    
  



    
  <script type="text/javascript">if (!NREUMQ.f) { NREUMQ.f=function() {
NREUMQ.push(["load",new Date().getTime()]);
var e=document.createElement("script");
e.type="text/javascript";e.async=true;e.src="https://d1ros97qkrwjf5.cloudfront.net/30/eum/rum.js";
document.body.appendChild(e);
if(NREUMQ.a)NREUMQ.a();
};
NREUMQ.a=window.onload;window.onload=NREUMQ.f;
};
NREUMQ.push(["nrfj","beacon-1.newrelic.com","9dfe439095",8763,"Il9dRhNbCVtVQhgXQgBTVkFOWgpTVUMYF1oORw==",0.0,411,new Date().getTime(),"","","","",""])</script></body>
</html>




