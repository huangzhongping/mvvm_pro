/*
 * Copyright (C) 2016. Tripint Information Technology Co., Ltd. All rights reserved. *
 * Authors:lirichen
 * File:.java
 * This software, including documentation, is protected by copyright controlled
 * by Tripint Information Technology Co., Ltd. All rights are reserved.
 */

package com.example.networkrequest.exception;

/**
 * 错误码
 */
public class ApiException extends BaseException {

    public static final String ERROR_CODE_001 = "100001";
    public static final String ERROR_CODE_002 = "100002";
    public static final String ERROR_CODE_003 = "100003";
    public static final String ERROR_CODE_004 = "100004";
    public static final String ERROR_CODE_005 = "100005";
    public static final String ERROR_CODE_010 = "100010";
    public static final String ERROR_CODE_011 = "100011";
    public static final String ERROR_CODE_012 = "100012";
    public static final String ERROR_CODE_013 = "100013";
    public static final String ERROR_CODE_014 = "100014";
    public static final String ERROR_CODE_015 = "100015";
    public static final String ERROR_CODE_016 = "100016";
    public static final String ERROR_CODE_017 = "100017";
    public static final String ERROR_CODE_018 = "100018";
    public static final String ERROR_CODE_019 = "100019";
    public static final String ERROR_CODE_020 = "100020";
    public static final String ERROR_CODE_021 = "100021";
    public static final String ERROR_CODE_022 = "100022";
    public static final String ERROR_CODE_023 = "100023";
    public static final String ERROR_CODE_024 = "100024";
    public static final String ERROR_CODE_025 = "100025";
    public static final String ERROR_CODE_026 = "100026";
    public static final String ERROR_CODE_027 = "100027";
    public static final String ERROR_CODE_028 = "100028";
    public static final String ERROR_CODE_029 = "100029";
    public static final String ERROR_CODE_030 = "100030";
    public static final String ERROR_CODE_031 = "100031";
    public static final String ERROR_CODE_032 = "100032";
    public static final String ERROR_CODE_033 = "100033";
    public static final String ERROR_CODE_034 = "100034";
    public static final String ERROR_CODE_038 = "100038";
    public static final String ERROR_CODE_041 = "100041";
    public static final String ERROR_CODE_060 = "100060";
    public static final String ERROR_CODE_063 = "100063";
    public static final String ERROR_CODE_064 = "100064";
    public static final String ERROR_CODE_075 = "100075";
    public static final String ERROR_CODE_076 = "100076";
    public static final String ERROR_CODE_095 = "100095";
    public static final String ERROR_CODE_096 = "100096";
    public static final String ERROR_CODE_097 = "100097";
    public static final String ERROR_CODE_098 = "100098";
    public static final String ERROR_CODE_099 = "100099";
    public static final String ERROR_CODE_100 = "100100";
    public static final String ERROR_CODE_111 = "100111";
    public static final String ERROR_CODE_112 = "100112";
    public static final String ERROR_CODE_113 = "100113";
    public static final String ERROR_CODE_114 = "100114";
    public static final String ERROR_CODE_115 = "100115";
    public static final String ERROR_CODE_116 = "100116";
    public static final String ERROR_CODE_117 = "100117";
    public static final String ERROR_CODE_118 = "100118";
    public static final String ERROR_CODE_119 = "100119";
    public static final String ERROR_CODE_120 = "100120";
    public static final String ERROR_CODE_121 = "100121";
    public static final String ERROR_CODE_122 = "100122";
    public static final String ERROR_CODE_123 = "100123";
    public static final String ERROR_CODE_124 = "100124";
    public static final String ERROR_CODE_125 = "100125";
    public static final String ERROR_CODE_126 = "100126";
    public static final String ERROR_CODE_127 = "100127";
    public static final String ERROR_CODE_128 = "100128";
    public static final String ERROR_CODE_129 = "100129";
    public static final String ERROR_CODE_130 = "100130";
    public static final String ERROR_CODE_131 = "100131";
    public static final String ERROR_CODE_132 = "100132";
    public static final String ERROR_CODE_133 = "100133";
    public static final String ERROR_CODE_134 = "100134";
    public static final String ERROR_CODE_135 = "100135";
    public static final String ERROR_CODE_136 = "100136";
    public static final String ERROR_CODE_137 = "100137";
    public static final String ERROR_CODE_138 = "100138";
    public static final String ERROR_CODE_139 = "100139";
    public static final String ERROR_CODE_140 = "100140";
    public static final String ERROR_CODE_141 = "100141";
    public static final String ERROR_CODE_142 = "100142";
    public static final String ERROR_CODE_143 = "100143";
    public static final String ERROR_CODE_144 = "100144";
    public static final String ERROR_CODE_145 = "100145";
    public static final String ERROR_CODE_146 = "100146";
    public static final String ERROR_CODE_147 = "100147";
    public static final String ERROR_CODE_150 = "100150";
    public static final String ERROR_CODE_151 = "100151";
    public static final String ERROR_CODE_156 = "100156";
    public static final String ERROR_CODE_157 = "100157";
    public static final String ERROR_CODE_158 = "100158";
    public static final String ERROR_CODE_159 = "100159";
    public static final String ERROR_CODE_160 = "100160";
    public static final String ERROR_CODE_161 = "100161";
    public static final String ERROR_CODE_162 = "100162";
    public static final String ERROR_CODE_163 = "100163";
    public static final String ERROR_CODE_164 = "100164";
    public static final String ERROR_CODE_165 = "100165";
    public static final String ERROR_CODE_169 = "100169";
    public static final String ERROR_CODE_170 = "100170";
    public static final String ERROR_CODE_171 = "100171";
    public static final String ERROR_CODE_172 = "100172";
    public static final String ERROR_CODE_173 = "100173";
    public static final String ERROR_CODE_174 = "100174";
    public static final String ERROR_CODE_175 = "100175";
    public static final String ERROR_CODE_176 = "100176";
    public static final String ERROR_CODE_177 = "100177";
    public static final String ERROR_CODE_178 = "100178";
    public static final String ERROR_CODE_179 = "100179";
    public static final String ERROR_CODE_180 = "100180";
    public static final String ERROR_CODE_181 = "100181";
    public static final String ERROR_CODE_182 = "100182";
    public static final String ERROR_CODE_183 = "100183";
    public static final String ERROR_CODE_184 = "100184";
    public static final String ERROR_CODE_185 = "100185";
    public static final String ERROR_CODE_186 = "100186";
    public static final String ERROR_CODE_187 = "100187";
    public static final String ERROR_CODE_188 = "100188";
    public static final String ERROR_CODE_189 = "100189";
    public static final String ERROR_CODE_190 = "100190";
    public static final String ERROR_CODE_191 = "100191";
    public static final String ERROR_CODE_192 = "100192";
    public static final String ERROR_CODE_193 = "100193";
    public static final String ERROR_CODE_194 = "100194";
    public static final String ERROR_CODE_195 = "100195";
    public static final String ERROR_CODE_196 = "100196";
    public static final String ERROR_CODE_197 = "100197";
    public static final String ERROR_CODE_198 = "100198";
    public static final String ERROR_CODE_199 = "100199";
    public static final String ERROR_CODE_200 = "100200";
    public static final String ERROR_CODE_201 = "100201";
    public static final String ERROR_CODE_202 = "100202";
    public static final String ERROR_CODE_203 = "100203";
    public static final String ERROR_CODE_204 = "100204";
    public static final String ERROR_CODE_205 = "100205";
    public static final String ERROR_CODE_206 = "100206";
    public static final String ERROR_CODE_207 = "100207";
    public static final String ERROR_CODE_208 = "100208";
    public static final String ERROR_CODE_209 = "100209";
    public static final String ERROR_CODE_210 = "100210";
    public static final String ERROR_CODE_211 = "100211";
    public static final String ERROR_CODE_212 = "100212";
    public static final String ERROR_CODE_213 = "100213";
    public static final String ERROR_CODE_214 = "100214";
    public static final String ERROR_CODE_215 = "100215";
    public static final String ERROR_CODE_216 = "100216";
    public static final String ERROR_CODE_217 = "100217";
    public static final String ERROR_CODE_218 = "100218";
    public static final String ERROR_CODE_219 = "100219";
    public static final String ERROR_CODE_220 = "100220";
    public static final String ERROR_CODE_221 = "100221";
    public static final String ERROR_CODE_222 = "100222";
    public static final String ERROR_CODE_223 = "100223";
    public static final String ERROR_CODE_224 = "100224";
    public static final String ERROR_CODE_225 = "100225";
    public static final String ERROR_CODE_226 = "100226";
    public static final String ERROR_CODE_227 = "100227";
    public static final String ERROR_CODE_228 = "100228";
    public static final String ERROR_CODE_229 = "100229";
    public static final String ERROR_CODE_230 = "100230";
    public static final String ERROR_CODE_231 = "100231";
    public static final String ERROR_CODE_232 = "100232";
    public static final String ERROR_CODE_233 = "100233";
    public static final String ERROR_CODE_234 = "100234";
    public static final String ERROR_CODE_235 = "100235";
    public static final String ERROR_CODE_236 = "100236";
    public static final String ERROR_CODE_237 = "100237";
    public static final String ERROR_CODE_238 = "100238";
    public static final String ERROR_CODE_239 = "100239";
    public static final String ERROR_CODE_240 = "100240";
    public static final String ERROR_CODE_241 = "100241";
    public static final String ERROR_CODE_242 = "100242";
    public static final String ERROR_CODE_243 = "100243";
    public static final String ERROR_CODE_244 = "100244";
    public static final String ERROR_CODE_245 = "100245";
    public static final String ERROR_CODE_246 = "100246";
    public static final String ERROR_CODE_279 = "100279";
    public static final String ERROR_CODE_289 = "100289";
    public static final String ERROR_CODE_290 = "100290";
    public static final String ERROR_CODE_291 = "100291";
    public static final String ERROR_CODE_292 = "100292";
    public static final String ERROR_CODE_293 = "100293";
    public static final String ERROR_CODE_294 = "100294";
    public static final String ERROR_CODE_295 = "100295";
    public static final String ERROR_CODE_296 = "100296";
    public static final String ERROR_CODE_297 = "100297";
    public static final String ERROR_CODE_298 = "100298";
    public static final String ERROR_CODE_299 = "100299";
    public static final String ERROR_CODE_300 = "100300";
    public static final String ERROR_CODE_301 = "100301";
    public static final String ERROR_CODE_302 = "100302";
    public static final String ERROR_CODE_303 = "100303";
    public static final String ERROR_CODE_304 = "100304";
    public static final String ERROR_CODE_305 = "100305";
    public static final String ERROR_CODE_306 = "100306";
    public static final String ERROR_CODE_307 = "100307";
    public static final String ERROR_CODE_308 = "100308";
    public static final String ERROR_CODE_309 = "100309";
    public static final String ERROR_CODE_310 = "100310";
    public static final String ERROR_CODE_311 = "100311";
    public static final String ERROR_CODE_312 = "100312";
    public static final String ERROR_CODE_313 = "100313";
    public static final String ERROR_CODE_314 = "100314";
    public static final String ERROR_CODE_315 = "100315";
    public static final String ERROR_CODE_316 = "100316";
    public static final String ERROR_CODE_317 = "100317";
    public static final String ERROR_CODE_318 = "100318";
    public static final String ERROR_CODE_319 = "100319";
    public static final String ERROR_CODE_320 = "100320";
    public static final String ERROR_CODE_321 = "100321";
    public static final String ERROR_CODE_322 = "100322";
    public static final String ERROR_CODE_323 = "100323";
    public static final String ERROR_CODE_324 = "100324";
    public static final String ERROR_CODE_325 = "100325";
    public static final String ERROR_CODE_326 = "100326";
    public static final String ERROR_CODE_327 = "100327";
    public static final String ERROR_CODE_328 = "100328";
    public static final String ERROR_CODE_329 = "100329";
    public static final String ERROR_CODE_330 = "100330";
    public static final String ERROR_CODE_331 = "100331";

    public String errcode;
    private String errmsg;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public ApiException(String resultCode, String msg) {
        this(getApiExceptionMessage(resultCode, msg));
        this.errcode = resultCode;
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     *
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(String code, String msg) {
        String message = "";
        switch (code) {
            case ERROR_CODE_001:
            case ERROR_CODE_002:
            case ERROR_CODE_005:
            case ERROR_CODE_010:
            case ERROR_CODE_011:
            case ERROR_CODE_013:
            case ERROR_CODE_014:
            case ERROR_CODE_015:
            case ERROR_CODE_016:
            case ERROR_CODE_017:
            case ERROR_CODE_018:
            case ERROR_CODE_019:
            case ERROR_CODE_020:
            case ERROR_CODE_021:
            case ERROR_CODE_022:
            case ERROR_CODE_023:
            case ERROR_CODE_024:
            case ERROR_CODE_025:
            case ERROR_CODE_026:
            case ERROR_CODE_027:
            case ERROR_CODE_028:
            case ERROR_CODE_029:
            case ERROR_CODE_030:
            case ERROR_CODE_031:
            case ERROR_CODE_032:
            case ERROR_CODE_033:
            case ERROR_CODE_034:
            case ERROR_CODE_041:
            case ERROR_CODE_063:
            case ERROR_CODE_064:
            case ERROR_CODE_075:
            case ERROR_CODE_076:
            case ERROR_CODE_096:
            case ERROR_CODE_098:
            case ERROR_CODE_099:
            case ERROR_CODE_100:
            case ERROR_CODE_111:
            case ERROR_CODE_112:
            case ERROR_CODE_113:
            case ERROR_CODE_114:
            case ERROR_CODE_115:
            case ERROR_CODE_116:
            case ERROR_CODE_117:
            case ERROR_CODE_118:
            case ERROR_CODE_119:
            case ERROR_CODE_120:
            case ERROR_CODE_121:
            case ERROR_CODE_122:
            case ERROR_CODE_123:
            case ERROR_CODE_124:
            case ERROR_CODE_125:
            case ERROR_CODE_126:
            case ERROR_CODE_127:
            case ERROR_CODE_128:
            case ERROR_CODE_129:
            case ERROR_CODE_130:
            case ERROR_CODE_131:
            case ERROR_CODE_132:
            case ERROR_CODE_133:
            case ERROR_CODE_134:
            case ERROR_CODE_135:
            case ERROR_CODE_136:
            case ERROR_CODE_137:
            case ERROR_CODE_138:
            case ERROR_CODE_139:
            case ERROR_CODE_140:
            case ERROR_CODE_141:
            case ERROR_CODE_142:
            case ERROR_CODE_143:
            case ERROR_CODE_144:
            case ERROR_CODE_145:
            case ERROR_CODE_146:
            case ERROR_CODE_147:
            case ERROR_CODE_150:
            case ERROR_CODE_151:
            case ERROR_CODE_156:
            case ERROR_CODE_157:
            case ERROR_CODE_158:
            case ERROR_CODE_159:
            case ERROR_CODE_160:
            case ERROR_CODE_161:
            case ERROR_CODE_162:
            case ERROR_CODE_163:
            case ERROR_CODE_164:
            case ERROR_CODE_169:
            case ERROR_CODE_171:
            case ERROR_CODE_172:
            case ERROR_CODE_173:
            case ERROR_CODE_176:
            case ERROR_CODE_177:
            case ERROR_CODE_178:
            case ERROR_CODE_179:
            case ERROR_CODE_180:
            case ERROR_CODE_181:
            case ERROR_CODE_182:
            case ERROR_CODE_183:
            case ERROR_CODE_184:
            case ERROR_CODE_185:
            case ERROR_CODE_186:
            case ERROR_CODE_187:
            case ERROR_CODE_188:
            case ERROR_CODE_189:
            case ERROR_CODE_190:
            case ERROR_CODE_191:
            case ERROR_CODE_192:
            case ERROR_CODE_193:
            case ERROR_CODE_194:
            case ERROR_CODE_195:
            case ERROR_CODE_196:
            case ERROR_CODE_197:
            case ERROR_CODE_198:
            case ERROR_CODE_199:
            case ERROR_CODE_200:
            case ERROR_CODE_201:
            case ERROR_CODE_202:
            case ERROR_CODE_203:
            case ERROR_CODE_204:
            case ERROR_CODE_205:
            case ERROR_CODE_206:
            case ERROR_CODE_207:
            case ERROR_CODE_208:
            case ERROR_CODE_209:
            case ERROR_CODE_210:
            case ERROR_CODE_211:
            case ERROR_CODE_212:
            case ERROR_CODE_213:
            case ERROR_CODE_214:
            case ERROR_CODE_215:
            case ERROR_CODE_216:
            case ERROR_CODE_217:
            case ERROR_CODE_218:
            case ERROR_CODE_219:
            case ERROR_CODE_220:
            case ERROR_CODE_221:
            case ERROR_CODE_222:
            case ERROR_CODE_223:
            case ERROR_CODE_224:
            case ERROR_CODE_225:
            case ERROR_CODE_226:
            case ERROR_CODE_227:
            case ERROR_CODE_228:
            case ERROR_CODE_229:
            case ERROR_CODE_230:
            case ERROR_CODE_231:
            case ERROR_CODE_232:
            case ERROR_CODE_233:
            case ERROR_CODE_234:
            case ERROR_CODE_236:
            case ERROR_CODE_237:
            case ERROR_CODE_238:
            case ERROR_CODE_239:
            case ERROR_CODE_240:
            case ERROR_CODE_241:
            case ERROR_CODE_242:
            case ERROR_CODE_243:
            case ERROR_CODE_244:
            case ERROR_CODE_245:
            case ERROR_CODE_246:
            case ERROR_CODE_279:
            case ERROR_CODE_292:
            case ERROR_CODE_293:
            case ERROR_CODE_294:
            case ERROR_CODE_295:
            case ERROR_CODE_296:
            case ERROR_CODE_297:
            case ERROR_CODE_298:
            case ERROR_CODE_299:
            case ERROR_CODE_300:
            case ERROR_CODE_301:
            case ERROR_CODE_302:
            case ERROR_CODE_303:
            case ERROR_CODE_304:
            case ERROR_CODE_305:
            case ERROR_CODE_307:
            case ERROR_CODE_308:
            case ERROR_CODE_309:
            case ERROR_CODE_310:
            case ERROR_CODE_311:
            case ERROR_CODE_312:
            case ERROR_CODE_313:
            case ERROR_CODE_314:
            case ERROR_CODE_315:
            case ERROR_CODE_316:
            case ERROR_CODE_317:
            case ERROR_CODE_318:
            case ERROR_CODE_319:
            case ERROR_CODE_320:
            case ERROR_CODE_321:
            case ERROR_CODE_324:
            case ERROR_CODE_327:
                message = msg;
                break;
            case ERROR_CODE_165:
                message = "";
                break;
            default:
                if (msg != null) {
                    message = msg;
                } else {
                    message = "未知错误";
                }

                break;
        }
        return message;
    }


}

