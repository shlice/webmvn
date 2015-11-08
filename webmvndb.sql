-- MySQL dump 10.13  Distrib 5.5.34, for Win32 (x86)
--
-- Host: localhost    Database: webmvndb
-- ------------------------------------------------------
-- Server version	5.5.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `title` varchar(200) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `attach` blob,
  `text` text CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (30,'user001','title','ÿØÿà\0JFIF\0\0\0\0\0\0ÿÛ\0C\0ÿÛ\0CÿÀ\0\0m\0n\"\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁRÑð$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚáâãäåæçèéêñòóôõö÷øùúÿÄ\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3RðbrÑ\n$4á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚâãäåæçèéêòóôõö÷øùúÿÚ\0\0\0?\0þô(ªTÓ[nÛëS¹‚®&C“ò`›ÛãÚz2,æ&Sû[KÀ\"þÔç‰“÷q€“»rm=|{s½3Â¡\'´dý\"ÿ\0àÿ\0]Î?c[þ}Tÿ\0Ásó]ŸoÏVÓnþ8\0d·œõ<ç9#åÉÉ$‚Fî—œ0äâ9\nQ“÷xÉe Ù>;ñWã—Ãÿ\0ƒ>\Z>!ñ–±\Z™ã•´MÚ{/í›b†é´«{›ÈU-m·êZŒ¶º]š=¸ºÔ¥†Iž_ÚÃþ\n-ñKãLú¯…|¬Þü;øx¦kIl|3©O£â]í¦«ât‹û<îV+£¬*âUŒoŽ@—~6oàrZSxº–«ov’º“–­sn ´ÕÉ7ºrqRý+ÃOøÇÅmZ9L·(ÿ\0kg™‹•¯+¦ä”§^ªRrŸ.ªœ¿¿(\'ÿ\0i~3ÁB¿e‚×Ú¿ñ\"x³Oaçƒ~ÙMâÝvÊíäTz´ÚtŸØž¿\\ƒýŸâ\rNÂýÁ‡É·s4+/ç×à´kqqkð·à&ët•EžµñÅ¢ßíÑ<°®[Ã¾±»Ô,Lk\"|ßl¼óˆU	6æÅ+0»ÐYý‘¡šX6‡ÏUxNBîu+}Ý²³	X¹%ÅÜZ¥•…ö‹¤ÌÑË©ë÷OŸe(žòÖÑ­…ÝÐùe_±hæ@\0mæS#‚ni¾ÙùÖ3ójõ/…¤°8dâ¹çN3”ß:‹<£&¶zÆÖRŠi¨Ê«þÐá¢o‡9Vu¸‡™ñf+Ü³†d²ÜûÎ.ßÙ‘©U6´åþÑ”ù»(¹¯Òýþ\nóûYj\':.ðkÂéG•áÿ\0kÏ\"“ñý³â@QSvòÉµ¦>K]\'…¿à®µ~Ÿ42x‡MøGã;rW}œ~×¼4×*^v]iÞ\'× w\0å·@¡&q\Z]~fx»J2è¾1ÒÒBåô­zÎ;ØZH|Õ:UÉûm“å#†ç2îU>zJMï™~ÏÞ4oü>Ñ®.î¾Õ«i0C¢ëY/þ‘ujÖÛïB´’uk7\Z¡;¤yˆÛ)žóÏ‡qhºÕqé[—NH)?}¤â›jÖ‡½weG\'&¦åöqðÁ…<6^¸,”±©ªmç9Ú©«š\\•§œ:’stýÄß7¿óÊRu§ûëá/ø->¸»SÇ?³þŸ©oeCqà5·Û­·‰tß2éGšÍ²CH¯q™\0¶{Ÿ´~ÁS¿dÏ‰«ëúïÂ½]Äq­§ÄÍ0iºl“1@#‹Å\Zmæµ¡C®Ù¯ï¬ÄÒ‘\ZKf—ùžK7À\'Ì“Ì±f;–aþŠ €„WÊœÊey\Z2ÓÉ4{\nÛ¢1ÁÁ?½aSó”€ªŸ¿æ™¸3n–KÎì»Ž3\\?2ÆR†9E«-)»%9;¸+·g8Þ÷‚»œdçó|AôPð»5£/ì¥šð®1$£¯5žiIÉû^W(æ:©ìî¢ä¡Sš^â„â¥*ûqÑµM;ZÓ¬µ]R±Õ´ÍFwc©i×¶·öÖ’\0RæÊöÒYíîàfÀÂåüÂW!š]A’3žúŒ|Áˆ<îÎ8`Uy\nIþ;ÿ\0gßÚsã7ìÑ«®¡ðÓÆsA¢ÍsÚÇõ¿´Þø\'ÄŽÆÜ]Éqáòît­F1±›Rð·‘ªÌ3¬æâSwý%þÉ?¶wÃOÚ·Â«&†ÏáÏiPB<Mà]Fán5O’\"Ú®r\rkB”Í]E3%¤’-¾ªSi4ÿ\0{’ñ.:æ„?ÙñI.j2Rþj¶”d×hsr½b­iIÇ~(xÆ>ÊX¬W±ÎòMFžu–­i^U#æÙjœ«å3“VN£–	ÎQ„1R©%ìz+=5m-ÆSQ³`q‚.bÁÎÂ¤ü†ß\\IÒDˆJWM ¾·`s²«€¤“Œ26î›^6ÉŒ~’zû²Òßeõ½¯Úú[{Ý®—{\Zßóê§þŸ——§Þ·ëâKˆ¢lb]×y;¿{#—wQ—Þ@½—s‰®|·ã\'Åíà__ÆÚÜº–µªI-§ƒü3yt,¢Ö56íš¶­pÏ\"éÞðÂ˜µ-WSØÛ¤—MÐ´8î<AªxRÞóÑ¯umÃºV·âŸß¦—á	é²kÞ#Ô§+¶+håƒn•\\Ýê6²Xã‘¤•˜¬e·ƒ?óÑûPþÐºÿ\0ÇøÅšÀ—NÐlÄqiš/Xì4=9à¼Ó4Á([M2[YÀ(úÍåèŒH²øAîöã.*¥ÃØGNœ—ÖñqZ½9bÕFÜ¬ä•ÒºRwiÁ8J“?}àÄñï¼¡WX,›f\\Q™4ïý›ÌÜrªVÖeœrÚ‹÷ZæSW²¿“þÑ¿´g‹¾.jþ!ñOˆµ[­FÊî[8v¤>Dþ!k‰t}\ZÒËÌ•¼?£-Ö¨4­@!ô›1(ñ‰³¯Ë\'îüÓÁ:h÷^4Õ 2Û‹·³ð´x-o¬ê¯ßˆ¾W¼i´/QÝ \rCÄE¦x:K¿ñìž/ñÏÂŸƒ–ÓÉc¨x†kÏ‰Þ8ºMÄh~\nÒšLr’>Ý$úv#	<íUôÖvŸÎlúŠöïL¶³T’+m#DÐ¬a²Ó­K²XØé–ÒBÃ8y	Á8|î2†&C)•ž÷ð\'B¬Ô±X¥/­clîâå)¨ÊV¿ºæÓRRÒ-Ýû­sM¿íìšž_—að¼5“a‡²F¯ðsssUWIC•J¢V´“‹Wrrs«#ÇüG>áYñ¿=½†¦[Iww;þïÌd9Àbà`°ë¼JÌ 4Í+µßÇ~ñF½¬xWâ^­¦\\ÿ\0ÂWñïÆÞøcðGÂÓ£­\'À—šÎ”ºÇŽoìÀ“û6ÃV±Æ£ý¢ZQ\"Ýià‰ßU-{ëÓé÷ß´ß‰í¤\Z}Ôÿ\0<;­Yiún‰h¾]ÿ\0Æý¶ÜYxrÊÑ–_ø‘-äƒû_PüÂ­á²Ó¼i5ßØÞ+ýœdøQ«| ×|^¶úÄsâ6±sh‘áÏxW@¸ðß‚<à›HÃ\r?DÒüqñ3JÕu}EL¿ð“k1Ÿ¹›F²ð§ÚÕ*t°­Ñ©{_•ý¦¤êT\\ÎÍ¦ïÉÉ½£ï8Ô¬þwŠ¸Û<]·i,tc”åÖRåk›8I&ŸÚþÌqm{Ðº”“çó}gEŽîÏ[$³G}ºÊ×·ž5kølìÈbÎC)Ô­É+æ	®€Ü™îþ?ð§Áï~È´ˆþø®âçUðÏŠá‹Vð‰fˆù>\'ð®©}Ñï/0%ÎµðûZ3øÅË‰¤ºoˆÀ™¼O3^~™ü5ðHñ÷Ä†¾	µµûiÕµÛ-Jê&!”èúšUÕß!¤T:µüéÄî]·‰Ä¯>ôÿ\0‚‹þÂv¾éz×…-Šx»ÁñÇªøOS—0ÝYx ŽÆîÊöðyßñ$ñèa¥ëŠÛ„šÄ¶ ó\'™äK§…£/eŽµžñS~ô“¼ê&Ô¥ïJÖæjÖ¥ï¸ÞoÈã(ðßp®ëQæÂeiiunGYr¹¶Õ¤ã^[Å·%	Nõy¿,´}.dm&ácŠßXòl¼ù0VÞÿ\0u¨³½\roYO>g›»Pé\r)û_ G> º½Í¬ê:F¨ú&­i&ÌAqk,Š3¨+æÝ› \\<®/{‡ZÜ^2ð†“­\\ÛÍk©<riÚ¾›rÆÞúÇÄzUÜv:®yk¹‚_iWÖw,¬K³É#\0\'y•®èjÓCañ¦\rª>ÉñSáÍ—ˆ•Al?‹<+¬Ãi¬_\";;Õlu4Ü>v?OR÷>hû_6…£‚»‹j	Yëï6ùS†úÅÊ1–±ÑNRIËõ:yìR¡Œ¦“ÁãýéÞÒ½¥RÒsQsµ¦ÚQvÞI¸¯k,Ïì7$åCùŸfæ;]ÙíÃÙ”ò²1û²‚³™ÞQößLø/âO|8ñ®‘â¯ß_iºÎ=î™%‹«Kzð#ûµÙÚ|ÅÕÚcá¯™©$—Ó(ÈùH‘KF0D-j  ýç“‰\Zg~|ç™~×6AeÝy1f†x‰_;››ƒ2žOß&C+L‹ºa)7¹ÑýÔý´%leìåî¥	OY+èß.ê¯\'5:µù…L&{—ãrœÏÇ	÷\\yoÎ¥:ÉsEÆ§4\Zø›æn.1|É¹?éà§Å}/ãÏÃ›YCk´‚ÓOñmŒÊöê­m\rí–¯¥Ÿ1¤\Z7ˆl$]CKick¾÷GiåžÚïí¡	’Š”À–iI\"<‚“±À,›šC½œùÒ~5þÂ?¿áø™§hš…Ë§†>#G‘m!Ê‚ò{è­<ÔÞÌ¨lu­N†‘Ø¶‘ªø“$–~ußì’ZM¦Íqc!Q5¼Ž’¬K±”…Ûp@èB0mÊþh$É?ôgï=Ê´’Ž\'(Sœ\"’N.|ª\\°“I+rÅ½[”“QgùñÆœ+_‚¸§4áéTSÃrÒÍ2YsNnY^>U½6æÜœò™Aå•\Zæ—º¹Û“æ?<à¡î4-/Hø¦]‰¥‘-<sñgf[«e¿’ßáÿ\0…/Uå?ñ/Ôµ;[j¨¥¾mÖ73«ˆn<O©	ŸBÑÕŒ’kšÕŒ—m½Ú´Í1­µk°à«äj×–pi  qtùË+5ß ß|fñ?ÅMÄ<c¨G«ø§Æ7ð\rSQ[‡:uäv¶ºoƒü;gg¹¦T°Ò¬4+çóš­Þ¦¸ydûgÎ—\ZáºñÅ©G3.“ávºFeY.5MjÖÈ~ì´¤]pÝæI\0gn—Ÿ‡qo<ß2ÆÖ”ycÙEµ*±’R’IGK­î­}\"Òþ½ð—ðn	ZïŸ¸æ¹£i·ý¬§4“QWþÌöpIÉ%%”ÊmÇ™T“­ðÎØßüLý >(ß9¸þÕÕ</ð›Â¦gÿ\0™WÀV‘^jÿ\0dÁíO\ZøÂãTÃšeQóJörµÞ_‰õ8¾/ß§„.ukýI³Õl´íOÁ\Ztw‘|AñÖ¢ÏÙ4«\"@Ðµ_½£êzg™ý©¼35›Î>×ÙhÑ_ê7Úg†<)¡Þx“[ñ Ðhº”¶‹sªêwwðÝ^¶ÝêXiºyÕüG«4ÚEƒI!Ù?œæ÷õÛöNý¾\0ü¼Ó>%ünø›ð·Ç?n`H Ò4ø\'QÐþ\ZÛO%¨»Ò4?¶xƒûEoX¹mgSÞßÚ¨ìªdÒ\'“Âw\\˜ZxœÊR­Ißá¼¬õÖN2ÑI­ýËsI«»º’uLüAâÎðË(xLV/ûC6Ç¨gÊ.£u˜T«˜µœsÉFI\'IÙB6øœ¡\'Õ~Âß°‡ü\":V‡ñâ†…§éšˆÓÒÏÂ¾³ŽØéÑ¼ÈÒ¬)ªê‹êjòxzC>†ò=çÊÿ\0·¿mõßÚÆö–L’ZøBÏÃ? *•:lêþ Œ]ÝöÖ¿o¥€wîÕ4á”‘&?lýçñt\rxO^ø…ªÍo‡|7á›_ÜyÁ¡ŸFÓ4Èõvr	“ªÙ#|¾b³È[{¬¡®¿—„þñ·í‹ñ™|9fÓ¥×ÄMbïâÄ=hGt#ðï„µ=V{í^êîó/þŸªYêÃ::îu“V—Sýì‰k#ÝöfG…Áá°TRúÖ`ã.nUg)¸¥u\'\'eî­!ï¦¥)¹Éþ1á>cS;â¾&ñ‹ñ\\¹O	e/2JKÝŽiŽW”å‘ræŠu=‹í9E­SU)?Ðø\'ÂïÉ§ø³öƒ°ðZx²ÿ\0[ºÓ¼ðÎÇS¾´ÑôË}.Öòªø¿WÕ¯]ïãÑ?´	Õ´Û=CTÔÄ\Zø|Í4é5Çë~àÙßBÕl<eªÅâÝ[Ä¦×îRÍ¬ôwÜ«ÿ\0hÂCý›¡éhÒ™™õIK_{›™§–ž~:|oøWû|ð}Ö¥e{¦x3K6>Ð´Ïø+âŒõ‹¡gl­¥‡‡ü£k—÷·b;0¬Ú¡€Èd\ZV•’ëó¢Çþý“×Å\'áæðöÒøñ	í$ÕWÂþý’þ\"Zê²èöv©u{z4OjúN¶¶idF£ý cdeºÓUL¯*½Ï¹•eŽ–T¨ágt¡gÈìß<Ô¯tÜ“KFù¢Ÿ3jM¹¿Ã¸¯Škñb³¼N%O™Õ_Ùsä“§N¥NGKšrI®]“§/vÒ©>wåÿ\0¶gìÿ\0{û>üTÕ|S¦[ÈÞ\rø¯{Ü×hÆVvöËö®?ä¾)²²[[™\Z_[‰F²ÍwùùñÅXxïöyºwóMÏŒµÿ\06Ýúv«áI¯A ³~×am…&MÂU9gïö&÷öØø-ÿ\0ÒŸöpÿ\0†iý®þø³Ç²CàÏ|`ýž|Eá­Dñ\r­¬ZÖ‘«êÞ ¯iÚg—yj¥ïw#üÆQ0?ÏÇßßøoãìùà}~ÔÛx‹MøžÚ»¥É)3éþ!³¼Õ|3uj2eÚ¯¡ÊAÛ\'›¤HQ‹É>û¿˜Ì2ÚØLNFÒVj:?yFsä³ù¹Å&ÛR”cÌªNMÿ\0Xø)ÆÔ8Ÿ„ñ™Ni‰—×2“¦Üå”¼Ý§%(É­/Íg×I%Å?Ð5mÈ$H	ˆ³n+½[ìÛ¹c#;Q²\ZS\'š±æO<›ë	««ûÉ_pˆôb%ËÚ`ä4p0PeY\ZQ?*×ž&ºÌÏ­iÖ¾æ6—“Æ[LÞi––n2ÌT¢±#å”ÌÕšvr÷{©\"C˜åŒ\"Á·œ­’w¾ÎYºÈ$T\"bî×ž5\nœ´gQZë•%³kÚÉs;=æ åw§3j-·R/úBžOj˜Öù®ÒqN2ŠƒSªš•”•ÕÓnWn7“§$¥nðŠ\"Óµ].è6DW¶1ÈÞyu6÷_g³¼`ÉÈb ¹bêIŸz›ïécá¿‹[Æ_\rþøòêâigñ\'„ì$Ôîö1ûV¹b‘i:µÒDÉv+ëÝ.æú=ªë‰Ë	Ù§Ÿù!¶ñ¶“ÅR;¼‘éSE¨0ƒçý¦Ú¦ûò9èê®ø“ÌóŸ8N>Ûý-ÿ\0Á:<A?ÄÙ_Á÷O+Ýdëþ1Ò¡Ýól“èWåXÜ€U/AÝ°³ù†S3³½ÍÇèÞãc†Ì1øxJ-b¢ªZM8¾WU¶×6š.{sÝ;6äÛ¨ÿ\0•>”¹pGçôª9SÂæ™®K9$¥ý¦«f0m¨üJY+I¹9Y&ê5-žÿ\0ˆZf‹á_3ÂžO/@Óoc‡Kƒxc&›ý•¥jû@@ë^0Ô0¬Ü8Ü× 7¿1êZŽ²ž$ñÓøvÎÇTÕlô	Z¤Z®¢,¬-Õ¤÷_m¾û!}Cû?÷ª³´Ï3ÍY$MÓ½Ë5çºxÄÏ»©ZL¥€Ø±Ì‹ÍÞ—¦(0ûÀ9	ÅÃHâïåÿ\0\njqOñãæ‹$»®ŸBø©ZÚ,$·´ÒîtrÌw67ÏWi§™^_2óótïõûêÒ…ÓisÖww|·IÆÏw¬å6Ûþ¬Ë©QÁåÙƒMÂOM¿á&KYs4Ÿºä¿›š“wR?~?fÏø$7ìsñCà§À¿ˆÿ\0´Â+‹Ÿ|OðçÂÚÿ\0‹<G¨øÓâ&›¥ÞK¯me´+Ãú\'‹´Í>ÃCÒ­5(Æ•§#Iº7Äo«Ks,÷šðLØÓö1øµÿ\0\"ÿ\0‚Àü&ñ—ì±ð¿Åžý¼yàO\n|1ð×‹4TÖôÿ\0	ZÝjž(ûrèŸo*Wì6ï½ÝÒ$7\r%çôñð\"(bø+ðf([1§Ã†‚%Ç@<áeŒšVÂî#¾Vf\0IæÌ×??ðEÍ#R³ÿ\0‚¦ÁÁÚÅÜyh_‡šP›çIÒo\ZÝ*±–\"ÆþÕð»Ölîw–IîTË¤©áq¸j[Ã*Ê“‚ƒ|ÖRW»Œ¹¹­Ï%}rrr—ùCžc1–h³<Â¯Öñxü})©Ë8óU¯6£ïÝAFIE+5¢¦Ÿ+¦ß·ëëñü\Zðì›ð/Áé}âV>Ò|1£ÈtÝ#BøIàÆÓo¼G{­]„cáD¯¥xaµÞ¬×É\ZÃ¬<Íàë¿iýŽdß\rþÊß\'Ó~Ù‰<{â™¬õŸˆþ3û7ÙÛ]ÖD1BaÑí‘ç\Zw„ôÔq§i:koÞ3Ê²Í+KsõZ>‹ý®ÚáÒìÿ\0¶n4Ë]mTZ·ÝhöW¿l´Ò^ð–a`··÷\ZØpÎò\0%’Y~Õqy*ÇrÈÑ\r˜ÈTÅ…$±Âç04*‰]œÜùÑÃÑ©[Û¸ß‘Fö»~ÎU*¸¥Å«Î	´Û÷cîÊnS—¬³œÊžAS†ðÕ^,ždó,Î1åšTµE	Ô´¬Õ%´_ºçÍ9Ý¤šK\nÜBÊñ¤¤˜y–5˜8Ê\0Üv}ÌwL¨ÀÍü½þÏ+Ô5oø9\'öÐÚòòH<?ð×Æ‚1utÑ«Â§øP¹Ãy l%J¶Êó;)˜ÊóÞP¤þînbÃxÕv\0Ü¤ýâL‡q”HåÃö;ðÌÚü“ÿ\0×Â1‡Ãÿ\0µýBèä0™u?|\rðå®Ë¸:‹dþoœý I#Ýz¹b‹¥ßo¨E¶ãe¤½ÖïµéÌö»i¶x8ÛòáÕ}ršµ•õ½­ø%ªiÊ:§F_ÔŸ™$‰,M=Ó©ò@U»¹kY£ßÒÀÊáA234{¦2ºþ@ÿ\0à²³Þÿ\0‚š~Ì<=¥L<ñ¯NñGÅ½zKX?Ð,<sð¯Â¶ÞÔÍâ*Ê	ñOü&:F¦Änó]5E	0ž÷úùVýêG‘)—vWŽ6tK…ÈÃîyQ—åºiÏüØÿ\0Ájh­Dø…¦éè-u!ð#Á³ØÃnŒMÎ±ñGâMÞ—w¤x>Çi—ŸØÚu‹jÀ‰£ÔÆ½ºO°˜n¼b_RÆ7k{Ž7NÍF¥E{5Ì×¸åe+]µ9Ê.Mþ³à¥MOrJXwËƒMæYÄyT“Éò¹C6Ìž©¥+déÆM\'­¬ãI~iøZ—Å?¾*LˆfÑü!?†|fà–[­gìÖú¿ˆ|0C¥Þê:Y9s\'šÁšàÍ+^zÜjí`Ò3ˆÕFWlŒïlø9’Bœ’	j9‘\n™ü÷ûg”ü\nð]ç‚>èšv±)½ñ&¨Òø—Å×eƒ\\ê~,ñä\ZÖ«zï/ÛuÓŸ0>ÕdyÌáï;¶ÔBjÚF’€™î­®îfˆç2ÛZ>aµFéþ?u\"I7y˜\'y›íŸQ§ÍN“Õ]s8É»óTMÛVÓ÷tÖË•I.X£ý\"Ê½¼pXZ¸·|n`’‹q‹nÒ›”ÛK™J7ÛJs·?4æ±ã…ï¯|}hŒÒ½Ö“¡YdÒÏ=Ö—2¾óí€sæy‚Bû¦yÞK¿ßOø ÏŽ/üUû.µ})™­~0|Fð”a˜—2ø.ÏÁÞÕ›j™ßÛV:‘Ür»œ¶ïÞ$ó?Þ\0Õ ×®üs­[0šâÙt;I	9¼·ðµ¼:5ÍáÉ•A7Í0Ì##&ÙÌÆkßé;þ	5á@ýŠ¼# x>\"mñãF©âH\"hq‰<EãXüE~qt ˜õKfû…Îã#O!v¹Ÿï<5Tq™Ò¨Û~ÎíÍh”e8´®£w¶Ó¿//+šs‘ü·ô¬¤åÁ19rÇ>*PÛQqy^xãvö»„Z¼^ôï)Oš¡øSñcá÷þ|Añ?‚þ%éÂÛÆ:9Ð¥Ö¢*½å¾¥ éw:Må˜ù‡ØÀC§\"O3V:žLâR.ÿ\0;|a¬Ûü>ý§ô-^úcm¤üIÐ¬<\rsw+‚Yõco§è÷wÊÂF\n5»m/÷‚O3ûIw	Ìûî¿ªßø*çÀ?x¯áŸ´œOŸ~6™¢jÖ	Iqñ\'Ã\Z¾²‰‡#yoxnKûcÂ’0yÞÂ][AaqÓ$ÿ\0ÌÇÄ¿xâ/ˆ¿gïøÙê^Ñ¾/ü-³ø‡w!\\¯€o>\"xJóÄ\"øæC§ÿ\0d‹9[ Èl]Ã8œÉ?Û|~ Èc’g²ÃóGêØåÚÏVåË%Ëvâ’”.ÛVø”’—7Øxuâ<øËÂ÷ÇÍžð:§Ó+÷ï›æ¸háý‘îÙK9ÊÛN÷\\ís9M)Kúöý™þ.hú—ìùðånZY.>ø:ÞINù¼³áý#Gðåá»o1Ž>Ý¥gd™L®Ë‰g2ºðïØÿ\0öXÐ?goÚSöþý tÏˆ7Þ-ŸöËø¥áj>“CM2\\è^M>çF7Ÿm‘|Az÷—Ï/ö¡ÜÒ+®Ó$“Ü5Ïmû(|ñŸÁx—à—ŠYüK¦ø/ÄW7Ÿ<r‘‰müWðó]¼ŸWÑ¬ïîI•4ïøùî4ÝfËæ/æXx‹DO}ÇÕÞø~ºbD‹Ž)6Ä\'\r¶UÁÿ\0Xä¸*û†LÎîfúHÎ­(Êš1¼Uš‹Z6Ü}è¶œÞ©s>ks9§9Éÿ\0ã0ü$¾¿S;Z¤e—+Y{/mR¤>$åÂ0÷t4£$ç	³Ñlnc»Œ:à³ðA]C&;¹!€%NXr7HµÅ”åÆq–’>|	ËtóÏÍ¸Ê«ûÂÇÏ†ÊÜ[Ä‘ƒæ6Ãƒ\'ú³’Ho/¿zdiç•ó¹‰@­Ð8V€¨ÆâNò>o1dl™;]/ÚZ=§k)Jö|®ZÝY]»¶ï>o’4ù/ËkGš÷ø÷¶–WÖí+])EµÃx·Ä¯£ZI6R‘EÄheûfd„p\0‘“%ç{HÒƒûÆfk‚<!û=|&øoû[|gý¯ü5£ë³|aøçàO|7ñÌcY¶“Ã	m£\r\næÍ´«§8²Öµ[?ix®ðÞ¾™&›h¯¶iu77?¢z†‡¥Ä†Üû3†âM¬NK°\n2K\r­¸‘µeIöž6ÛÀ–Æè xæt{£ûÖOµý’Þ;›Œ•wÚ«fÀnÁÞÄ™·ÉçáÔç•.YÉÆÉ®Y;IT”m¬¥åËôswÕJIÅ}FUŠáêXIG‡‹–)¾h¶¥ÈÔÖÎêtÝìîœ¢ÒP„O<ø«û@èß¾ø÷âŠÞ;/Áºº¨‚Y–ªßæ+M#J³¼I$U:­ü°éƒ—$Í÷§<·_Äþ™ã­{öØøû­|Z×.¤Ö¾xSÅš§ŠáÔÑZ;Çß5KËQªø·Où¦) hë ð¿„	|!lGú@ÖTÞÿ\0@ßð[Ïâo†?\r¾ŸZé6>/ÕeÕ¤ðíÝáÕüF–æ[¯ë?,©aá\nØêŠÚVž&«âoj:rfÓB±ñÛ?.4‡^\ZøSá¿\r|=ð¾—›‡ô»vP±’Kë»})¾Ë|s\"‘¤Øˆ³™Dº¼Ã&Wµinüãõj3£E·ŠRŠVM]Þ´Zpå“\\És6®­ËË%)Urþžú;ð–OÄ«l.9«Zög¶«^Í^›¶Wu|á6¥Ìò„æãbìhIlÄù2ŽÙ‰FâÍ(ÁÞÎ,$Þ‹¶q<²Þü_ñã¬²øÏñ\nÊU¸»¶–Ãág€mŒÌPÔ­žãí:½WvÇöÎ¨\0“y“Nây&‘/}{ö†øš>xêK;€uÿ\0Ý\'„ü4¾i7j7VÑ½cpWÀÒ´WŸVU+)s&š¤\\4î/?+!–÷Å\Z§‡ô(Œ“iº‚8bÎF§¯]<GæÜ•ÒÚVþØ8˜‘&šÊ³³Þ|þYU(Ê¥x9h’º•®¥ìåi{®M´ì£.^^Í6ÿ\0 8—8–¬°[ÃmTÝ×=DÕÝ6ÓåM¥u%/~-ÍIKõ£övÐ¦Ð>ü9°º’KË¡ Yjú¬ò#PÔ5+ÙõkÛÄ*e*\rö ;HKÍ&?7Ÿ®ðNïÛKJýšô‹žñ­“êzfµ¯xoÄ^“x®$Ñî,5€òF&b¹²±laÑšF•¦gqsqù¹á½>=#BÒ4Å„ôý+JÓˆÜÛ¥û,\ZM–\nüímÀæS!v?é5Á»òÏŠŸì~jžûUá³}wÃ¯pXÆ\"ûI°×5kQ!WŽðeryTpæC)¹bÿ\0jºëÉ±Õ°Ù•J¸9(Þ:è¬“ö‹š7‹ºnNNïš\\ÊNsŠ‘âxŸÂ¹>À¯#Ïqrt)O$>^h»Âs’IÆW\\Ö„Ü¢î¤Ü&Û’¿ô©ÿ\0qñ•´~øIàX|eâmÅ\Z¬ñOr¾ð½äºD±ÈÞj¶ë‹k•agyØ§ÌiÄ7?Î_ˆü#áýjæ÷F‘Í…ÏŒ´ËÛ;Øã$é¾$€Ûi\"èë:P3hÞ©)mIŒš»ù¬Œó¼ån¿gà³þ\'ŸÀzÏÁ´z†¡¢ø3CÓüCªÙiÖÂú]CFc±ñmžXßßjžÔu[Ð´ÞjNpó	¤ŽëñOöƒZð‡†[Åž„ø†ëáæ§cã}>{\"ÓÁâ¿«Ëg«›3‡Ú5=PÓÈ5Pøl½Æ½6û¿wŒãR|CŠ¬¹yp”éeŠí©8ÔU%y^-=l”u’“K–QRƒü¿èÏS.Àøq,ºµåõ¥™qRótsœ×*n~ìä¸´^ü“¤•Y¯ß²\'üÛàgƒ¼3ðçö¸Ö<AàŸiÚ6…¦|`Òí.µ}OÃ\Z]¥¶›ckÄ­&Í¤ÔõíJcã-2KýZËJhGˆ´TÜ\\xêûöÛáGÅ¿…Ÿ\Z<=eã/„?|+ñ+Ã—ñG%¶±á\rn×X¶pæ‹rÖ²²é÷[_si×áµ2ßJñý§øåðO‹<3ñCÂV>\"Ðîmõ}Ä6°ùÑHÞc][[Gyg|äÌUCJ>u‘iû@šo¶~|x«[ø“û(|]¼¼øOñÆ\rõ\rB)5o\rx‡Á¾ »Ð¯oí–÷ŸÙdótíxª‰q§jŸÚUTù§4—¼ùf{V§´Ââ¢´æ’m;s8ÇZÏTâÕœ¥zrI(Ô”¼¾ŽùU>!áÖ$³çý“8¿ì¸ÞuSp£(s¿•·¦Ô•æÿ\0Ñ”*¥òAÚŸ˜:«Eƒ\\‘Û8mêYƒLÎÏ7Ä¯Bæ4¶ñMàAd°ðÄÈù‘€ßl²Ðf²P(i7—Û‰„žeÏñCðßþÙû}ü)¸ðv•«øÿ\0Á¿´=jÖæañWÁ:a½[k[m&îÑ¯|Aáù¼!zÿ\0ÚÇS:h$.ÌeÌ¬ë-çëìÿ\0¯ý¨¿l=kân—áŸÙWáŸtÏ„þºñ‹¼_á?ˆ¾)Ð4õ“h÷:?¬o5];Æ¶š‡Š¼[öV\ZM†˜Ò-€–6ñ›Îµý^U†©šÔ•¿õÙ.]%£+ÔšQ\\¨Ý4í/…í\ZŽU/üÇÅ<œðnÎêå/ƒ”\"åC<Ë[†•yœ²ÉÆžfÔ¹RŠ§¤Z»P¿|GÅ?A(’];ÇDI\'Â¿‰Å¥(bL²ÙxZ@¡Kå\"f.ViåñV™§ø›D\ZÅßŠn<9áù4-DkZ…Ô6º}½ïƒu}2íë]]5€ÇÃê,‡Í¨¶ýNÅd¿$Ê¬ë?ã·Áïø)íÉûMé:_‹¼\'û3|.ý™¾k¡²ñÅOxâÄrÀÉl~×áèÖ>Ñ4ß,Éýž·þ)Ô&S$‹,i«hÎ&»òïÛOâŒ<Sðsâ^™â¿xëâ½ìhÖ´Ûÿ\0ìøQuûÍ2È]kðÉÓ4øõ­RÆYÛGðæ­y«êm(Û¢L³Iã{Ï\'û]RÅ:X,Ç”S†WM¨Z.q‹»æiÙAÅ$îôçmË›“-á,vj°ÿ\0Z<«	Œ©•e®yœï7,ÍÉåÓpT¤šªÓ»öŽÉß•N1GÊ¿þ2ÇûXþÕÞ:ñÌgð§„“A°ð¾Ÿ9Y!±ðv–nWÁ\ZQo2QNÊÚßÅ:¶ï00ñ`\\<÷gâ;´Ôu­zö$Þ—z]Ûòn±}\0éä¨,†UÊ¹’à¹’÷Cá·ÂK¯€\ZçÆÝ7]-/‰5àkæâQ8‡YñO‚|yÿ\0í¡ùÔiþ³Ki\n­>‘lŒæg7Ÿ·Çí)oð#áf›¢éÚœ0øëã¨¾ðæ5K+›\r84CÄ^/7›äû\0Ò¬™´Ã¨‘!³ÔîÛ™ÌàÝüÞ\')Ì*çXÌ²®›óDÒŠ¼®ç(ÞM\'‚/WÊ•ýé9UOý\0àÌã†8cÃ¬¯‰(bRáÜ¿-É£”¸¦–nÔ«G\'w•6’Î–w€væ’½Ûƒ½Dþqý¥þ,\'Ä‰+cáÛ¸ï,ô¯¼3á)Œâky1oÿ\0	oŽ˜ælØÛK]+H\\:êÅKÊÚ»5ä²Ï…­üCñÃš]”ãMÒuË½RêIÜ£¤d]ÝÝÞge\Z¦µ3±Æÿ\04Þ>^áî^x7À¯\0k¾\"Õz7•ãøïWÐ|á›M¼ë	-ä\ZG†ü9áûÜØÿ\0nI¿9ræSâ\"&–âïíŸjÁ4¼\r¯\'€5ˆÞ-Ž&ºÕ®õmK’&_&äÿ\0Â[¨ÞøY³\ndÀÞµ¦š@y›@Ýp×\n÷{bpË…ÆJN/êÊ”yeªn£V‹Ñ5ì¹¥gÍË8Ù©ûYGfQÎ¸¯-£Šð­–k›¾un|¯-y^R¤›”›K4Ói«Jó2¼¾äø‡âðÿ\0†®n!%õ^çJðî—l½KUÔb³³b»Ý@Póê€09P\\™…ßËÿ\0·÷ìÁñ+ân•ð/Æ^»’ÃLKˆ~\r2Gf÷Qê7ÚÞ\nñ½Û‰½Ða¥ŠðijÛX²Åæy¤È÷W\Z¾\"ø›aâïŠúD6ðÝkø_,Ú¼ðiîÆø§u½•™WŒÚvŸ§é&â53!•Á4ï<²]ýíãø*7ìy{ðÃáÂ«?é>ñ\'Â™ütÞ$Ó¼g­éºä(›ÆmàûŸøMtO}‘­¯žúûÃšž±g5Ÿö›Ã§y×\")wÜvð¦E:Ó«‰ÅÉ\'È¥ð«ÝÔtÖŠ\rò´Ü¢šrQ·2nœ³ñÛÅÔ8[+¯Ãytè`±S¿žB›Ëò¨×Ê2¼â¬*RyšrŒóyg\n¤\ZWjŒ¥)¹IþòÁF?fï~Ðÿ\0\0–_	x~x£ÀQkË¨xSN‡í\Zßˆ¼\'ªDÑ]ÜøeÁ˜jZ‡‡®š-U4 \ZMGHºÕ#ÐZ?…ãË?á—¾\n~ß\0þü\\ð»iðÓâ©Ò‡üou”/´ÿ\0ˆºdvöÞ(Ñ¾$xrÕ´Ëý:ûP¼»¸ñÛ´é,Î¤Úšø‡Ä#YŽådºý^×­¡Òµ‹k<=»/Ìd}£`hÆÜ¶G¹;™ƒy€8f7-.F‰¥ø~ÖçÄšµ‡†ôM3^ñ5¤#Äšæ›d¶wzûiÒ\\›ke\"a§|‚ÞT]BôMx±Ü2yÅÂ_ÙqÜ5ÇU«˜V¥N¦9ŠŽi‚Ÿ½	KštÛWW|²W“Mó««:‹ÛKø?ÅüE“eù3\'ÆÔË+å9¦e™åyÎK™åqÌ`ÿ\0µrº±›ÆÒÌrÊ“Â<Æ*©¸VXŠP„ž7ÏâÓãüóö©ý|u}ã7áN«â?‚¾ »ŠïÅzg€\'¾ñ\'„ôYïuQµjVZkK¥Ø+©Ô%ðïŠ¬­õm>LEá©u\ZiZûã/ø(uºÂ¤ð?Å]#º›Ã^(ðÔqDOö¦“©jú}âï™,Þm+†“Ìûi&K†’_·s¶f¿¬ø{ö+ýµ|A¡êWzn¡£~ÌŸ5M>hfbÖ×ö^ñRÛ\\B_!\ZØ¸²Þ2°b×m7ù†ÝüQñô?o¾\ZÜxŸTÔ¼ªê\ZE½×‡õK—Ô ·’ûd[\"{Ã=Æÿ\0è¬BÛ?>ióšR×­qÅ–ø\'[7­ŽÌ2|ÑUž_™äËû\'1nòï¥9¬ÁB¤£9*nSm¦›‹÷gúµ¥\'.È¸‹…¸Ë&§(bò¬Æyfy”ÅÓ£“æ‹œjÏ*uªº1›jòÊš·2÷cjŠQüý’~!~Öž-ø¥Ëñ@ðN“áOë~?¸×<gs¬ê¶+áëoiZ5–‹¤éáÚ;õmV0W\ZFf–I¤kÏêëþ«âoÁ6¾ø—àÏÆßüL—Æú¿Š?hO\\ð•Þ—\rŸ„|sáxjÏNñg…¼Pú7ÚõMRÛÂ·ö•ÐÔ”ºKÄÒî¸þobý~ÿ\0BøÛáý&Ø«éÚûEá¯Y¾|cF]GKÔþÉr¬dÂÙÞÝ‘ç	¯’ã÷ÅºE–½ðßâ§Å/µïŠ|Qeñ«ÃþCª_ÜÛèá­YÓml4ƒáÝô½û6%šåþÄö.®f>t²3^<ÿ\0è‡ø%ÁYÞE‚Èó<6=f¸œÚ¦Eý¥—cg„rtó\\¹#S“•æ”óy9©(Ôr…_hœ¨¿ò»Å¯xÓ\'ã*•ÿ\0´ò¹åùÔ²|×*©™å/2¥•K0«ˆÉŸ½oí+kfÓÍZ§6ÿ\0Ø«EÅÔÇÔ¨~˜|øðãSuÑuh¼}ðëàë‹ïˆÞÑ<5&™­üPÕþxƒWžóÂ>½×îõ-\'@ð0ÒYåÓ5|_6³.Š<5áÓ<ºæ«ã\Z]û7ÅOÛ#ö7øËû5j¾ð/ÂŸŠ?¼ðóÇ^ñV•â	üà˜<3uwàÏi~#×ïCYüOmwÅƒÄ±ØÏ¥jú˜ÚÆ±«^Ë3\\´Ÿlþ4Ÿˆ¾<ÖuèW\'¾Óôÿ\0‡ÿ\0¤øoèË¼ºþ€ž/ÕîâŸY]N=fÉu3‡ ³–ûM±³–8åy4Ÿìç7‚¶XÙj\Z¿ìÝðÆ]:ÖÏÁ§G¾ñ-î‹¥©†\rNÿ\0ÂÛ_L¶Ô¡ýª÷:jjI6²l¥.¡\"I$²bôÜ|·\n}ü*¥Af·eøŒÞŽkÄYvmB)d™m*ÓÍñžÖy­Oœc2©M`áQSMÁÖšR©\'ñØŸ¥g‹XºDsŒ_ËAAÒ”2œåÇ,Ê²üª9’tÎkf“i<«™IsJ2Î³‡SÛ9CûK~Ôß~%þÕž4ðWÅv#ñwÁ¿…ß5=Æ~ºðåÄ¡og²´:-¥ó»_ßiZµ‰Õœf1°V”K#Ýÿ\0\'¿·ÏÅ;ŸŽ´¯LI©øÀ×pü<ðÄ\nLÐ& ^Àu{¡ 2øª|M,Å†×2i)¦ö!{Ï²mŠÞ;ÿ\0†Òøïãû=`é~%ðŒ¯<-áMCN„@ÚvàÍZØXÈ­$Ÿj±Ôc±ºþÙ²”ìÔ¡rn¤’I/¤¸ø\'@™ïµïêwb9o\"´ÓÌPË5œšŽ¡Ã;ý¡sm#Î	l‰ˆ—Î/~×†á|Àe>%ñá±NT11¥ýŸÌ¹§æ9ËY¤¥òº®óå²NmJ*ë‘ÿ\0weH<×‹>Ž^ðFeƒyf:’Žq›Ã-œVYšå3Ëœ2¬²Q’sŠÊ¥ìœîÚÁåÎ£Y>ãöÇ^\Zý¡>kúümðUÒoîµ¿øËÂw––Zµ‡ˆ,ím“weg¬Xë¶Ya©Tµw<4ï,{ú—ã/Çáÿ\0€­þxÅ—7:]µ„~µ»ÒìtË;‹»k\'ƒíV–È¸ÔQ·gXÔ{¤¸šûÌÕæiÏ‚îÿ\0<~èVZÎ¹}©j^lñøSBñ/ˆÖÁdhíµ»Ý>ÖS¾·!/q{§nê,Þ]„Kûæ—7¿hô½c}ÕÌ7wò½Ü÷6fâòG 14Êml²$ûœínìl›y¬&yK^4ÿ\0â_á%Å“Âbùq”0YVY4¤åó8Î¤\\îá-+›½Ô’r¥\'ú×†>=Ä;ðŠ®MÃ¼•Ã‹8—5Í©ã|EÍùs~†U|²–W“dY}Üg?íxK6–ešËš”aS(s•Z‡)ªëšæ³Ø&¾¼þÇ3C3i¢ôµ…Öéw¶E¦°ÔoFðÊÍÈiÌñý³“±›Í¸ºÓ4½&çT¹°Kw¿ƒI±iž¹…\ZÑî#]mÈŽbµò²3±”Ý\\ú¿…|?a¯øãáÇ‚ï\'¿±Óüañ3À^ÕïôyláÖ-¬<E¯¶u¢\\jš~³icymn’¥™¾°Ô‚‰žÓ3_=Ç¤|lðo…¾|aø©àŸèöú‡<\'ñÆÒl¡ig¸m?Ã\ZÝ×…¬î5ûÇ¸ºÔõÄðñÔïï¯^[™õBöa\"É-Ô³|µ\nôp˜‰àhá“ŠŒj¶§¤—5KO÷‘“æv•Ô®¯i()®i~a™çy®oÍqw˜çs£l±kÉc~\nÜÚsIÊ)òsèÞ¼±S_¼rÿÙ','æµ‹è¯•å†…å®¹');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL DEFAULT '' COMMENT 'code',
  `password` varchar(100) NOT NULL DEFAULT '',
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `salt` varchar(45) DEFAULT NULL,
  `role` varchar(45) NOT NULL DEFAULT 'college',
  `fullname` varchar(100) NOT NULL DEFAULT '',
  `isTest` tinyint(1) NOT NULL DEFAULT '0',
  `invalidyear` varchar(4) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_username` (`username`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-08 14:51:08
