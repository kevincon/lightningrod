



  



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head><script type="text/javascript">var NREUMQ=NREUMQ||[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
    <title>src/com/lightningrod/gui/LRgui.java | Source/Git | Assembla</title>
    <link href="https://assets0.assembla.com/favicon.ico?1327583367" type="image/x-icon" rel="shortcut icon" />
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
            <span class="user-pic"><img alt="User picture" src="https://assets1.assembla.com/images/no-picture-hover-small.png?1330708843" /></span>
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
  <h1 class="icon-breadcrumb-path"><a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1" class="root">d4dfb28694</a>/<a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src">src</a>/<a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com">com</a>/<a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod">lightningrod</a>/<a href="/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod/gui">gui</a>/<span>LRgui.java</span><span>    <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
            width="110"
            height="14"
            id="clippy" >
    <param name="movie" value="/clippy.swf"/>
    <param name="allowScriptAccess" value="always" />
    <param name="quality" value="high" />
    <param name="scale" value="noscale" />
    <param NAME="FlashVars" value="text=git@git.assembla.com:lightningrod.git/src/com/lightningrod/gui/LRgui.java/" />
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
           FlashVars="text=git@git.assembla.com:lightningrod.git/src/com/lightningrod/gui/LRgui.java/"
           bgcolor="#FFFFFF"
           wmode="transparent"
    />
    </object>
</span></h1>
  
<div class="commit-infobox">
  <div class="commit-options">
    <a href="/code/lightningrod/git/node/logs/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod/gui/LRgui.java" class="revision-log" rel="nofollow">Revision log</a>
      <div style="margin-right: 10px;" class="small-icon-button">
        <a href="/code/lightningrod/git/node/live/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod/gui/LRgui.java" class="view-icon" rel="nofollow">View as a web page</a>
      </div>

        <div style="margin-right: 10px;" class="small-icon-button">
    <a class="download-icon" href="#" onclick="nobotGoto('!/code/lightningrod/git/nodes/d4dfb28694c326075834d9e9ad04d6e05630d5c1/src/com/lightningrod/gui/LRgui.java?_format=raw'); return false;">Download</a>
  </div>


  </div>

  <div class="committer-pic">
    <img alt="User picture" src="https://assets1.assembla.com/images/no-picture-hover.png?1330708843" />
  </div>

  
<div class="commit-info">
    <p class="committer-info"><span>Commiter:</span> <a href="/profile/BillVT" tabindex="-1" target="_blank" title="Show Profile">BillVT</a></p>

    <p class="committer-info"><span>Author:</span> <a href="/profile/BillVT" tabindex="-1" target="_blank" title="Show Profile">BillVT</a></p>

  <p class="committer-info"><span>Revision:</span> <a href="/code/lightningrod/git/changesets/d4dfb28694c326075834d9e9ad04d6e05630d5c1">d4dfb28694</a> </p><br />
    <p class="commit-size">
      <span>File Size:</span>
      13.3 KB
    </p>
  <p class="commit-date">(04 Mar 06:09) 24 minutes ago</p>
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
<a href="#ln135" class="block" id="ln135">135</a>
<a href="#ln136" class="block" id="ln136">136</a>
<a href="#ln137" class="block" id="ln137">137</a>
<a href="#ln138" class="block" id="ln138">138</a>
<a href="#ln139" class="block" id="ln139">139</a>
<a href="#ln140" class="block" id="ln140">140</a>
<a href="#ln141" class="block" id="ln141">141</a>
<a href="#ln142" class="block" id="ln142">142</a>
<a href="#ln143" class="block" id="ln143">143</a>
<a href="#ln144" class="block" id="ln144">144</a>
<a href="#ln145" class="block" id="ln145">145</a>
<a href="#ln146" class="block" id="ln146">146</a>
<a href="#ln147" class="block" id="ln147">147</a>
<a href="#ln148" class="block" id="ln148">148</a>
<a href="#ln149" class="block" id="ln149">149</a>
<a href="#ln150" class="block" id="ln150">150</a>
<a href="#ln151" class="block" id="ln151">151</a>
<a href="#ln152" class="block" id="ln152">152</a>
<a href="#ln153" class="block" id="ln153">153</a>
<a href="#ln154" class="block" id="ln154">154</a>
<a href="#ln155" class="block" id="ln155">155</a>
<a href="#ln156" class="block" id="ln156">156</a>
<a href="#ln157" class="block" id="ln157">157</a>
<a href="#ln158" class="block" id="ln158">158</a>
<a href="#ln159" class="block" id="ln159">159</a>
<a href="#ln160" class="block" id="ln160">160</a>
<a href="#ln161" class="block" id="ln161">161</a>
<a href="#ln162" class="block" id="ln162">162</a>
<a href="#ln163" class="block" id="ln163">163</a>
<a href="#ln164" class="block" id="ln164">164</a>
<a href="#ln165" class="block" id="ln165">165</a>
<a href="#ln166" class="block" id="ln166">166</a>
<a href="#ln167" class="block" id="ln167">167</a>
<a href="#ln168" class="block" id="ln168">168</a>
<a href="#ln169" class="block" id="ln169">169</a>
<a href="#ln170" class="block" id="ln170">170</a>
<a href="#ln171" class="block" id="ln171">171</a>
<a href="#ln172" class="block" id="ln172">172</a>
<a href="#ln173" class="block" id="ln173">173</a>
<a href="#ln174" class="block" id="ln174">174</a>
<a href="#ln175" class="block" id="ln175">175</a>
<a href="#ln176" class="block" id="ln176">176</a>
<a href="#ln177" class="block" id="ln177">177</a>
<a href="#ln178" class="block" id="ln178">178</a>
<a href="#ln179" class="block" id="ln179">179</a>
<a href="#ln180" class="block" id="ln180">180</a>
<a href="#ln181" class="block" id="ln181">181</a>
<a href="#ln182" class="block" id="ln182">182</a>
<a href="#ln183" class="block" id="ln183">183</a>
<a href="#ln184" class="block" id="ln184">184</a>
<a href="#ln185" class="block" id="ln185">185</a>
<a href="#ln186" class="block" id="ln186">186</a>
<a href="#ln187" class="block" id="ln187">187</a>
<a href="#ln188" class="block" id="ln188">188</a>
<a href="#ln189" class="block" id="ln189">189</a>
<a href="#ln190" class="block" id="ln190">190</a>
<a href="#ln191" class="block" id="ln191">191</a>
<a href="#ln192" class="block" id="ln192">192</a>
<a href="#ln193" class="block" id="ln193">193</a>
<a href="#ln194" class="block" id="ln194">194</a>
<a href="#ln195" class="block" id="ln195">195</a>
<a href="#ln196" class="block" id="ln196">196</a>
<a href="#ln197" class="block" id="ln197">197</a>
<a href="#ln198" class="block" id="ln198">198</a>
<a href="#ln199" class="block" id="ln199">199</a>
<a href="#ln200" class="block" id="ln200">200</a>
<a href="#ln201" class="block" id="ln201">201</a>
<a href="#ln202" class="block" id="ln202">202</a>
<a href="#ln203" class="block" id="ln203">203</a>
<a href="#ln204" class="block" id="ln204">204</a>
<a href="#ln205" class="block" id="ln205">205</a>
<a href="#ln206" class="block" id="ln206">206</a>
<a href="#ln207" class="block" id="ln207">207</a>
<a href="#ln208" class="block" id="ln208">208</a>
<a href="#ln209" class="block" id="ln209">209</a>
<a href="#ln210" class="block" id="ln210">210</a>
<a href="#ln211" class="block" id="ln211">211</a>
<a href="#ln212" class="block" id="ln212">212</a>
<a href="#ln213" class="block" id="ln213">213</a>
<a href="#ln214" class="block" id="ln214">214</a>
<a href="#ln215" class="block" id="ln215">215</a>
<a href="#ln216" class="block" id="ln216">216</a>
<a href="#ln217" class="block" id="ln217">217</a>
<a href="#ln218" class="block" id="ln218">218</a>
<a href="#ln219" class="block" id="ln219">219</a>
<a href="#ln220" class="block" id="ln220">220</a>
<a href="#ln221" class="block" id="ln221">221</a>
<a href="#ln222" class="block" id="ln222">222</a>
<a href="#ln223" class="block" id="ln223">223</a>
<a href="#ln224" class="block" id="ln224">224</a>
<a href="#ln225" class="block" id="ln225">225</a>
<a href="#ln226" class="block" id="ln226">226</a>
<a href="#ln227" class="block" id="ln227">227</a>
<a href="#ln228" class="block" id="ln228">228</a>
<a href="#ln229" class="block" id="ln229">229</a>
<a href="#ln230" class="block" id="ln230">230</a>
<a href="#ln231" class="block" id="ln231">231</a>
<a href="#ln232" class="block" id="ln232">232</a>
<a href="#ln233" class="block" id="ln233">233</a>
<a href="#ln234" class="block" id="ln234">234</a>
<a href="#ln235" class="block" id="ln235">235</a>
<a href="#ln236" class="block" id="ln236">236</a>
<a href="#ln237" class="block" id="ln237">237</a>
<a href="#ln238" class="block" id="ln238">238</a>
<a href="#ln239" class="block" id="ln239">239</a>
<a href="#ln240" class="block" id="ln240">240</a>
<a href="#ln241" class="block" id="ln241">241</a>
<a href="#ln242" class="block" id="ln242">242</a>
<a href="#ln243" class="block" id="ln243">243</a>
<a href="#ln244" class="block" id="ln244">244</a>
<a href="#ln245" class="block" id="ln245">245</a>
<a href="#ln246" class="block" id="ln246">246</a>
<a href="#ln247" class="block" id="ln247">247</a>
<a href="#ln248" class="block" id="ln248">248</a>
<a href="#ln249" class="block" id="ln249">249</a>
<a href="#ln250" class="block" id="ln250">250</a>
<a href="#ln251" class="block" id="ln251">251</a>
<a href="#ln252" class="block" id="ln252">252</a>
<a href="#ln253" class="block" id="ln253">253</a>
<a href="#ln254" class="block" id="ln254">254</a>
<a href="#ln255" class="block" id="ln255">255</a>
<a href="#ln256" class="block" id="ln256">256</a>
<a href="#ln257" class="block" id="ln257">257</a>
<a href="#ln258" class="block" id="ln258">258</a>
<a href="#ln259" class="block" id="ln259">259</a>
<a href="#ln260" class="block" id="ln260">260</a>
<a href="#ln261" class="block" id="ln261">261</a>
<a href="#ln262" class="block" id="ln262">262</a>
<a href="#ln263" class="block" id="ln263">263</a>
<a href="#ln264" class="block" id="ln264">264</a>
<a href="#ln265" class="block" id="ln265">265</a>
<a href="#ln266" class="block" id="ln266">266</a>
<a href="#ln267" class="block" id="ln267">267</a>
<a href="#ln268" class="block" id="ln268">268</a>
<a href="#ln269" class="block" id="ln269">269</a>
<a href="#ln270" class="block" id="ln270">270</a>
<a href="#ln271" class="block" id="ln271">271</a>
<a href="#ln272" class="block" id="ln272">272</a>
<a href="#ln273" class="block" id="ln273">273</a>
<a href="#ln274" class="block" id="ln274">274</a>
<a href="#ln275" class="block" id="ln275">275</a>
<a href="#ln276" class="block" id="ln276">276</a>
<a href="#ln277" class="block" id="ln277">277</a>
<a href="#ln278" class="block" id="ln278">278</a>
<a href="#ln279" class="block" id="ln279">279</a>
<a href="#ln280" class="block" id="ln280">280</a>
<a href="#ln281" class="block" id="ln281">281</a>
<a href="#ln282" class="block" id="ln282">282</a>
<a href="#ln283" class="block" id="ln283">283</a>
<a href="#ln284" class="block" id="ln284">284</a>
<a href="#ln285" class="block" id="ln285">285</a>
<a href="#ln286" class="block" id="ln286">286</a>
<a href="#ln287" class="block" id="ln287">287</a>
<a href="#ln288" class="block" id="ln288">288</a>
<a href="#ln289" class="block" id="ln289">289</a>
<a href="#ln290" class="block" id="ln290">290</a>
<a href="#ln291" class="block" id="ln291">291</a>
<a href="#ln292" class="block" id="ln292">292</a>
<a href="#ln293" class="block" id="ln293">293</a>
<a href="#ln294" class="block" id="ln294">294</a>
<a href="#ln295" class="block" id="ln295">295</a>
<a href="#ln296" class="block" id="ln296">296</a>
<a href="#ln297" class="block" id="ln297">297</a>
<a href="#ln298" class="block" id="ln298">298</a>
<a href="#ln299" class="block" id="ln299">299</a>
<a href="#ln300" class="block" id="ln300">300</a>
<a href="#ln301" class="block" id="ln301">301</a>
<a href="#ln302" class="block" id="ln302">302</a>
<a href="#ln303" class="block" id="ln303">303</a>
<a href="#ln304" class="block" id="ln304">304</a>
<a href="#ln305" class="block" id="ln305">305</a>
<a href="#ln306" class="block" id="ln306">306</a>
<a href="#ln307" class="block" id="ln307">307</a>
<a href="#ln308" class="block" id="ln308">308</a>
<a href="#ln309" class="block" id="ln309">309</a>
<a href="#ln310" class="block" id="ln310">310</a>
<a href="#ln311" class="block" id="ln311">311</a>
<a href="#ln312" class="block" id="ln312">312</a>
<a href="#ln313" class="block" id="ln313">313</a>
<a href="#ln314" class="block" id="ln314">314</a>
<a href="#ln315" class="block" id="ln315">315</a>
<a href="#ln316" class="block" id="ln316">316</a>
<a href="#ln317" class="block" id="ln317">317</a>
<a href="#ln318" class="block" id="ln318">318</a>
<a href="#ln319" class="block" id="ln319">319</a>
<a href="#ln320" class="block" id="ln320">320</a>
<a href="#ln321" class="block" id="ln321">321</a>
<a href="#ln322" class="block" id="ln322">322</a>
<a href="#ln323" class="block" id="ln323">323</a>
<a href="#ln324" class="block" id="ln324">324</a>
<a href="#ln325" class="block" id="ln325">325</a>
<a href="#ln326" class="block" id="ln326">326</a>
<a href="#ln327" class="block" id="ln327">327</a>
<a href="#ln328" class="block" id="ln328">328</a>
<a href="#ln329" class="block" id="ln329">329</a>
<a href="#ln330" class="block" id="ln330">330</a>
<a href="#ln331" class="block" id="ln331">331</a>
<a href="#ln332" class="block" id="ln332">332</a>
<a href="#ln333" class="block" id="ln333">333</a>
<a href="#ln334" class="block" id="ln334">334</a>
<a href="#ln335" class="block" id="ln335">335</a>
<a href="#ln336" class="block" id="ln336">336</a>
<a href="#ln337" class="block" id="ln337">337</a>
<a href="#ln338" class="block" id="ln338">338</a>
<a href="#ln339" class="block" id="ln339">339</a>
<a href="#ln340" class="block" id="ln340">340</a>
<a href="#ln341" class="block" id="ln341">341</a>
<a href="#ln342" class="block" id="ln342">342</a>
<a href="#ln343" class="block" id="ln343">343</a>
<a href="#ln344" class="block" id="ln344">344</a>
<a href="#ln345" class="block" id="ln345">345</a>
<a href="#ln346" class="block" id="ln346">346</a>
<a href="#ln347" class="block" id="ln347">347</a>
<a href="#ln348" class="block" id="ln348">348</a>
<a href="#ln349" class="block" id="ln349">349</a>
<a href="#ln350" class="block" id="ln350">350</a>
<a href="#ln351" class="block" id="ln351">351</a>
<a href="#ln352" class="block" id="ln352">352</a>
<a href="#ln353" class="block" id="ln353">353</a>
<a href="#ln354" class="block" id="ln354">354</a>
<a href="#ln355" class="block" id="ln355">355</a>
<a href="#ln356" class="block" id="ln356">356</a>
<a href="#ln357" class="block" id="ln357">357</a>
<a href="#ln358" class="block" id="ln358">358</a>
<a href="#ln359" class="block" id="ln359">359</a>
<a href="#ln360" class="block" id="ln360">360</a>
<a href="#ln361" class="block" id="ln361">361</a>
<a href="#ln362" class="block" id="ln362">362</a>
<a href="#ln363" class="block" id="ln363">363</a>
<a href="#ln364" class="block" id="ln364">364</a>
<a href="#ln365" class="block" id="ln365">365</a>
<a href="#ln366" class="block" id="ln366">366</a>
<a href="#ln367" class="block" id="ln367">367</a>
<a href="#ln368" class="block" id="ln368">368</a>
<a href="#ln369" class="block" id="ln369">369</a>
<a href="#ln370" class="block" id="ln370">370</a>
<a href="#ln371" class="block" id="ln371">371</a>
<a href="#ln372" class="block" id="ln372">372</a>
<a href="#ln373" class="block" id="ln373">373</a>
<a href="#ln374" class="block" id="ln374">374</a>
<a href="#ln375" class="block" id="ln375">375</a>
<a href="#ln376" class="block" id="ln376">376</a>
<a href="#ln377" class="block" id="ln377">377</a>
<a href="#ln378" class="block" id="ln378">378</a>
<a href="#ln379" class="block" id="ln379">379</a>
<a href="#ln380" class="block" id="ln380">380</a>
<a href="#ln381" class="block" id="ln381">381</a>
<a href="#ln382" class="block" id="ln382">382</a>
<a href="#ln383" class="block" id="ln383">383</a>
<a href="#ln384" class="block" id="ln384">384</a>
<a href="#ln385" class="block" id="ln385">385</a></pre></th>
            <td><pre class="prettyprint lang-java">/*
 * Lightning Rod - DropBox USB-Based Cloud Syncing Program
 * Lightning Rod GUI - Java GUI Application
 * Evan Benshetler, Mike Chen, Casey Conley, Kevin Conley, William Etter
 */
// Package Name
package com.lightningrod.gui;

// Import Dependencies
import com.dropbox.client2.DropboxAPI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
//import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author bill
 */
public class LRgui extends javax.swing.JFrame {
    // Selection Set
    static HashSet &lt;DropboxAPI.Entry&gt;s1 = new HashSet &lt;DropboxAPI.Entry&gt;();
    // Deletion Set
    static HashSet &lt;DropboxAPI.Entry&gt;s2 = new HashSet &lt;DropboxAPI.Entry&gt;();
    
    //static JTree filetree = new JTree((TreeNode)null);
    static DBNode rootnode = new DBNode();
    
    /*
     * Class that carries out mouse actions
     */
    class DBNodeMouseListener extends MouseAdapter {
        JTree mousetree;
    
        DBNodeMouseListener(JTree tree){
            this.mousetree = tree;
        }
    
        @Override
        public void mouseClicked(MouseEvent mevent) {
            int x = mevent.getX();
            int y = mevent.getY();
            int treerow = mousetree.getRowForLocation(x, y);
            TreePath  path = mousetree.getPathForRow(treerow);
            if (path != null) {
                DBNode node = (DBNode)path.getLastPathComponent();
                boolean isSelected = !(node.isSelected());
                node.setSelected(isSelected);
                
                // Check if node is directory
                if(node.childrenAllowed()){
                    // If selected expand, otherwise contract
                    if(isSelected){
                        //mousetree.expandPath(path);
                        expandChildren(node,path);
                    }else{
                        mousetree.collapsePath(path);
                    }
                }
                                    
                ((DefaultTreeModel) mousetree.getModel()).nodeChanged(node);
                //if (treerow == 0) {
                    mousetree.revalidate();
                    mousetree.repaint();
                //} 
            }
        }
        
        public void expandChildren(DBNode n, TreePath orig){
            TreePath expandpath;
            // Check if Directory
            if (n.children() != null) {
                Enumeration e = n.children();
                while (e.hasMoreElements()) {
                    DBNode node = (DBNode) e.nextElement();
                    expandpath = orig.pathByAddingChild((Object)node);
                    if(node.childrenAllowed()){
                        expandChildren(node,expandpath);
                    }else{
                        mousetree.expandPath(expandpath);
                    }
                    mousetree.expandPath(expandpath);
                }
            }
                
            /*
             * for (int i = 0; i &lt; jTree.getRowCount(); i++) {
            jTree.expandRow(i);
}
             */
            
            
            
            /*
            TreePath expandpath;
            if (n.children() != null) {
                Enumeration e = n.children();
                while (e.hasMoreElements()) {
                    DBNode node = (DBNode) e.nextElement();
                    if(node.childrenAllowed()){
                        expandChildren(node,orig);
                    }else{
                        expandpath = orig.pathByAddingChild((Object)node);
                        mousetree.expandPath(expandpath);
                    }
                }
            }
            *
            */
            //mousetree.expandPath(orig);
        }
    }

    /**
     * Creates new form gui
     */
    public LRgui() {
        initComponents();
        
        // * NEW CODE */
        filetreedisplay.setCellRenderer(new RenderChecks());
        
        filetreedisplay.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        filetreedisplay.putClientProperty(&quot;JTree.lineStyle&quot;, &quot;Angled&quot;);
        filetreedisplay.addMouseListener(new DBNodeMouseListener(filetreedisplay));
        //JScrollPane sp = new JScrollPane(filetreedisplay);

        
        JTextArea textArea = new JTextArea(3,10);
        JScrollPane textPanel = new JScrollPane(textArea);
        JButton button = new JButton(&quot;print&quot;);
        //button.addActionListener(
        //new ButtonActionListener(nodes[0], textArea));
        //JPanel panel = new JPanel(new BorderLayout());
        //panel.add(button, BorderLayout.SOUTH);

        //getContentPane().add(sp,    BorderLayout.CENTER);
        //getContentPane().add(panel, BorderLayout.EAST);
        //getContentPane().add(textPanel, BorderLayout.SOUTH);
        /** END NEW CODE **/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(&quot;unchecked&quot;)
    // &lt;editor-fold defaultstate=&quot;collapsed&quot; desc=&quot;Generated Code&quot;&gt;//GEN-BEGIN:initComponents
    private void initComponents() {

        filedisplayPane = new javax.swing.JScrollPane();
        filetreedisplay = new javax.swing.JTree(rootnode);
        updateFiles = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filedisplayPane.setViewportView(filetreedisplay);

        updateFiles.setText(&quot;Update File List&quot;);
        updateFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFilesActionPerformed(evt);
            }
        });

        jMenu1.setText(&quot;File&quot;);

        menuExit.setText(&quot;Exit&quot;);
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText(&quot;Edit&quot;);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(filedisplayPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 443, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(45, 45, 45)
                .add(updateFiles)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(54, 54, 54)
                        .add(filedisplayPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 381, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(updateFiles)))
                .addContainerGap(376, Short.MAX_VALUE))
        );

        pack();
    }// &lt;/editor-fold&gt;//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // CHECK FOR FINISHING TRANSFERS BEFORE CLOSE
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void updateFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFilesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateFilesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //&lt;editor-fold defaultstate=&quot;collapsed&quot; desc=&quot; Look and feel setting code (optional) &quot;&gt;
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (&quot;Nimbus&quot;.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LRgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LRgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LRgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LRgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //&lt;/editor-fold&gt;

        // Set Variables
        
        // TEST TEST TEST
        
        
        DropboxAPI.Entry entry1 = new DropboxAPI.Entry();
        entry1.path = &quot;test1&quot;;
        com.lightningrod.gui.DBNode e1 = new com.lightningrod.gui.DBNode(entry1,true);
        
        DropboxAPI.Entry entry2 = new DropboxAPI.Entry();
        entry2.path = &quot;ab&quot;;
        com.lightningrod.gui.DBNode e2 = new com.lightningrod.gui.DBNode(entry2);
        
        DropboxAPI.Entry entry3 = new DropboxAPI.Entry();
        entry3.path = &quot;test3&quot;;
        com.lightningrod.gui.DBNode e3 = new com.lightningrod.gui.DBNode(entry3);
        
        DropboxAPI.Entry entry4 = new DropboxAPI.Entry();
        entry4.path = &quot;a&quot;;
        com.lightningrod.gui.DBNode e4 = new com.lightningrod.gui.DBNode(entry4,true);
        
        DropboxAPI.Entry entry5 = new DropboxAPI.Entry();
        entry5.path = &quot;a&quot;;
        com.lightningrod.gui.DBNode e5 = new com.lightningrod.gui.DBNode(entry5);
        
        DropboxAPI.Entry entry6 = new DropboxAPI.Entry();
        entry6.path = &quot;best6&quot;;
        com.lightningrod.gui.DBNode e6 = new com.lightningrod.gui.DBNode(entry6,true);
        
        DropboxAPI.Entry entry7 = new DropboxAPI.Entry();
        entry7.path = &quot;best7&quot;;
        com.lightningrod.gui.DBNode e7 = new com.lightningrod.gui.DBNode(entry7,true);
        
        DropboxAPI.Entry entry8 = new DropboxAPI.Entry();
        entry8.path = &quot;best8&quot;;
        com.lightningrod.gui.DBNode e8 = new com.lightningrod.gui.DBNode(entry8);
        
        DropboxAPI.Entry root = new DropboxAPI.Entry();
        root.path = &quot;testr&quot;;
        rootnode.setUserObject(root);
        //com.lightningrod.gui.DBNode r = new com.lightningrod.gui.DBNode(root);
        
        rootnode.add(e6);
        
        e1.add(e3);
        rootnode.add(e2);
        //e1.add(e3);
        rootnode.add(e1);
        rootnode.add(e4);
        //rootnode.add(e1);
        e4.add(e5);
        e6.add(e7);
        e7.add(e8);
        
        // TEST TEST TEST END
        
        
        

        
        
        
        
       
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            // &lt;editor-fold&gt;
            @Override
            public void run() {
                new LRgui().setVisible(true);
            }
        });
        // &lt;/editor-fold&gt;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane filedisplayPane;
    private javax.swing.JTree filetreedisplay;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JButton updateFiles;
    // End of variables declaration//GEN-END:variables
}

/*




  class ButtonActionListener implements ActionListener {
    CheckNode root;

    JTextArea textArea;

    ButtonActionListener(final CheckNode root, final JTextArea textArea) {
      this.root = root;
      this.textArea = textArea;
    }

    public void actionPerformed(ActionEvent ev) {
      Enumeration e = root.breadthFirstEnumeration();
      while (e.hasMoreElements()) {
        CheckNode node = (CheckNode) e.nextElement();
        if (node.isSelected()) {
          TreeNode[] nodes = node.getPath();
          textArea.append(&quot;\n&quot; + nodes[0].toString());
          for (int i = 1; i &lt; nodes.length; i++) {
            textArea.append(&quot;/&quot; + nodes[i].toString());
          }
        }
      }
    }
  }

  
}



 */</pre></td>
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
NREUMQ.push(["nrfj","beacon-1.newrelic.com","9dfe439095",8763,"Il9dRhNbCVtVQhgXQgBTVkFOWgpTVUMYF1oORw==",0.0,794,new Date().getTime(),"","","","",""])</script></body>
</html>




