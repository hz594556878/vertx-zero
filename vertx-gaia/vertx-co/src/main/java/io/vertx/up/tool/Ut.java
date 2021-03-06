package io.vertx.up.tool;

import com.fasterxml.jackson.core.type.TypeReference;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Uniform Tool
 */
public class Ut {
    // --- Encrypt
    public static String encryptMD5(final String input) {
        return Codec.md5(input);
    }

    public static String encryptSHA256(final String input) {
        return Codec.sha256(input);
    }

    public static String encryptSHA512(final String input) {
        return Codec.sha512(input);
    }

    // --- Compare
    public static int compareTo(final int left, final int right) {
        return Compare.compareTo(left, right);
    }

    public static int compareTo(final String left, final String right) {
        return Compare.compareTo(left, right);
    }

    public static <T> int compareTo(final T left, final T right, final BiFunction<T, T, Integer> fnCompare) {
        return Compare.compareTo(left, right, fnCompare);
    }

    public static boolean equalDate(final Date left, final Date right) {
        return Period.equalDate(left, right);
    }

    // --- Vert.x ConfigStoreOptions
    public static ConfigStoreOptions loadJson(final String filename) {
        return Store.getJson(filename);
    }

    public static ConfigStoreOptions loadYaml(final String filename) {
        return Store.getYaml(filename);
    }

    public static ConfigStoreOptions loadProp(final String filename) {
        return Store.getProp(filename);
    }

    // --- Ensure Argument Length
    public static void ensureEqualLength(final Class<?> clazz, final int expected, final Object... args) {
        Ensurer.eqLength(clazz, expected, args);
    }

    public static void ensureMinLength(final Class<?> clazz, final int min, final Object... args) {
        Ensurer.gtLength(clazz, min, args);
    }

    // --- Network
    public static boolean netOk(final String host, final int port) {
        return Net.isReach(host, port);
    }

    public static String netIPv4() {
        return Net.getIPv4();
    }

    public static String netHostname() {
        return Net.getHostName();
    }

    public static String netIPv6() {
        return Net.getIPv6();
    }

    public static String netIP() {
        return Net.getIP();
    }

    // --- Array
    public static <T> T[] elementAdd(final T[] array, final T element) {
        return ArrayUtil.add(array, element);
    }

    public static <T> T elementFind(final List<T> list, final Predicate<T> fnFilter) {
        return Statute.find(list, fnFilter);
    }

    // --- Mr
    public static <K, T, V> ConcurrentMap<K, V> reduce(final ConcurrentMap<K, T> from, final ConcurrentMap<T, V> to) {
        return Statute.reduce(from, to);
    }

    public static <K, V> ConcurrentMap<K, V> reduce(final Set<K> from, final ConcurrentMap<K, V> to) {
        return Statute.reduce(from, to);
    }

    // --- Types
    public static boolean isBoolean(final Class<?> clazz) {
        return Types.isBoolean(clazz);
    }

    public static boolean isBoolean(final Object value) {
        return Types.isBoolean(value);
    }

    public static boolean isPositive(final String original) {
        return Numeric.isPositive(original);
    }

    public static boolean isNegative(final String original) {
        return Numeric.isNegative(original);
    }

    public static boolean isInteger(final String original) {
        return Numeric.isInteger(original);
    }

    public static boolean isInteger(final Object value) {
        return Types.isInteger(value);
    }

    public static boolean isInteger(final Class<?> clazz) {
        return Types.isInteger(clazz);
    }

    public static boolean isDecimal(final Object value) {
        return Types.isDecimal(value);
    }

    public static boolean isDecimal(final Class<?> clazz) {
        return Types.isDecimal(clazz);
    }

    public static boolean isDecimal(final String original) {
        return Numeric.isDecimal(original);
    }

    public static boolean isReal(final String original) {
        return Numeric.isReal(original);
    }

    public static boolean isDecimalPositive(final String original) {
        return Numeric.Decimal.isPositive(original);
    }

    public static boolean isDecimalNegative(final String original) {
        return Numeric.Decimal.isNegative(original);
    }

    public static boolean isDate(final Object value) {
        return Types.isDate(value);
    }

    public static boolean isJArray(final Object value) {
        return Types.isJArray(value);
    }

    public static boolean isJArray(final Class<?> clazz) {
        return Types.isJArray(clazz);
    }

    public static boolean isArray(final Object value) {
        return Types.isArray(value);
    }


    public static boolean isJObject(final Object value) {
        return Types.isJObject(value);
    }

    public static boolean isJObject(final Class<?> clazz) {
        return Types.isJObject(clazz);
    }

    public static boolean isVoid(final Class<?> clazz) {
        return Types.isVoid(clazz);
    }

    public static boolean isClass(final Object value) {
        return Types.isClass(value);
    }

    public static boolean isPrimary(final Class<?> clazz) {
        return Types.isPrimary(clazz);
    }

    public static boolean isNil(final String input) {
        return StringUtil.isNil(input);
    }

    public static boolean notNil(final String input) {
        return StringUtil.notNil(input);
    }

    // --- Serialization
    public static <T, R extends Iterable> R serializeJson(final T t) {
        return Jackson.serializeJson(t);
    }

    public static <T> String serialize(final T t) {
        return Jackson.serialize(t);
    }

    public static <T> T deserialize(final JsonObject value, final Class<T> type) {
        return Jackson.deserialize(value, type);
    }

    public static <T> T deserialize(final JsonArray value, final Class<T> type) {
        return Jackson.deserialize(value, type);
    }

    public static <T> List<T> deserialize(final JsonArray value, final TypeReference<List<T>> type) {
        return Jackson.deserialize(value, type);
    }

    public static <T> T deserialize(final String value, final Class<T> clazz) {
        return Jackson.deserialize(value, clazz);
    }

    public static <T> T deserialize(final String value, final TypeReference<T> type) {
        return Jackson.deserialize(value, type);
    }

    // --- To
    public static JsonArray toJArray(final Object value) {
        return Jackson.toJArray(value);
    }

    public static <T> JsonArray toJArray(final Set<T> set) {
        return Types.toJArray(set);
    }

    public static <T> JsonArray toJArray(final List<T> list) {
        return Types.toJArray(list);
    }

    public static int toMonth(final String literal) {
        return Period.toMonth(literal);
    }

    public static int toMonth(final Date date) {
        return Period.toMonth(date);
    }

    public static int toYear(final String literal) {
        return Period.toYear(literal);
    }

    public static int toYear(final Date date) {
        return Period.toYear(date);
    }

    public static <T extends Enum<T>> T toEnum(final Class<T> clazz, final String input) {
        return Types.toEnum(clazz, input);
    }

    public static String toString(final Object reference) {
        return Types.toString(reference);
    }

    public static Collection toCollection(final Object value) {
        return Types.toCollection(value);
    }

    public static Class<?> toPrimary(final Class<?> source) {
        return Types.toPrimary(source);
    }

    // --- Period
    public static LocalDateTime toDateTime(final String literal) {
        return Period.toDateTime(literal);
    }

    public static LocalDate toDate(final String literal) {
        return Period.toDate(literal);
    }

    public static LocalTime toTime(final String literal) {
        return Period.toTime(literal);
    }

    // --- Json Visit
    public static JsonObject visitJObject(final JsonObject item, final String... keys) {
        return Jackson.visitJObject(item, keys);
    }

    public static JsonArray visitJArray(final JsonObject item, final String... keys) {
        return Jackson.visitJArray(item, keys);
    }

    public static Integer visitInt(final JsonObject item, final String... keys) {
        return Jackson.visitInt(item, keys);
    }

    public static String visitString(final JsonObject item, final String... keys) {
        return Jackson.visitString(item, keys);
    }

    // --- Json Zip
    public static JsonArray zipperJArray(final JsonArray source, final JsonArray target, final String sourceKey, final String targetKey) {
        return Jackson.mergeZip(source, target, sourceKey, targetKey);
    }

    public static <F, S, T> List<T> zipperList(final List<F> first, final List<S> second, final BiFunction<F, S, T> function) {
        return Statute.zipper(first, second, function);
    }

    public static <F, T> ConcurrentMap<F, T> zipperList(final List<F> keys, final List<T> values) {
        return Statute.zipper(keys, values);
    }

    // --- Random
    public static Integer randomNumber(final int length) {
        return Numeric.randomNumber(length);
    }

    // --- Return
    public static JsonObject returnJObject(final Supplier<JsonObject> supplier) {
        return Jackson.validJObject(supplier);
    }

    public static JsonArray returnJArray(final Supplier<JsonArray> supplier) {
        return Jackson.validJArray(supplier);
    }

    // --- Perse
    public static Date parse(final String literal) {
        return Period.parse(literal);
    }

    public static Date parse(final LocalTime time) {
        return Period.parse(time);
    }

    public static Date parse(final LocalDateTime datetime) {
        return Period.parse(datetime);
    }

    public static Date parse(final LocalDate date) {
        return Period.parse(date);
    }

    public static Date parseFull(final String literal) {
        return Period.parseFull(literal);
    }

    // --- String
    public static String fromObject(final Object value) {
        return StringUtil.from(value);
    }

    public static String fromJObject(final JsonObject value) {
        return StringUtil.from(value);
    }

    public static String fromJoin(final Set<String> input) {
        return StringUtil.join(input, null);
    }

    public static String fromJoin(final Set<String> input, final String separator) {
        return StringUtil.join(input, separator);
    }

    public static String fromAequilatus(final Integer seed, final Integer width, final char fill) {
        return StringUtil.aequilatus(seed, width, fill);
    }

    public static String fromAequilatus(final Integer seed, final Integer width) {
        return StringUtil.aequilatus(seed, width, '0');
    }

    public static String fromExpression(final String expr, final JsonObject data) {
        return StringUtil.expression(expr, data);
    }

    public static String fromJoin(final Object[] input) {
        return StringUtil.from(input);
    }

    public static Set<String> splitToSet(final String input, final String separator) {
        return StringUtil.split(input, separator);
    }
}
