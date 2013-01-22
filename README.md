# Lightning Rod
Lightning Rod is a cross-platform Dropbox client for flash drives. It was written in 30 hours at the AngelHack hackathon in Boston, MA in March 2012, where it placed as a finalist.

App website: http://getlightningrod.com

It is written in Java and takes advantage of SWING for the GUI, Dropbox's Java SDK for accessing files, and [FileMonitor.java](http://geosoft.no/software/filemonitor/FileMonitor.java.html "FileMonitor.java") for monitoring the file system for changes.

# Wait, so does this actually work? 
Mostly. The team has not continued development since the hackathon, so the code and interface are very much unpolished. There are definitely bugs. There are also several quirks the team would have liked to have made better. For example, files remaining on the flash drive after a previous Lighting Rod session are not recognized. The files of interest must be re-synched for each new Lightning Rod session.

# How do I use it?
You'll need to compile the program into a JAR file. We used Eclipse and Netbeans for the development, but it's been a while since we've compiled it. We'll try to write a guide on how to get started building Lighting Rod soon.

# Is there any hope of you finishing it?
There is always hope. We're posting the code as-is with no warranty (see LICENSE file) in case anyone wants to contribute, but otherwise we do not have plans to finish it in the immediate future.

# License
Lightning Rod - A cross-platform Dropbox client for flash drives.
Copyright (C) 2013 Evan Benshetler, Kevin Conley, Casey Conley, Michael Chen

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
