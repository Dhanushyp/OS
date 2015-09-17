SUMMARY = "OpenSans fonts - TTF Version"
SECTION = "fonts"
HOMEPAGE = "https://www.google.com/fonts/specimen/Open+Sans"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
PR = "r0"
# we don't need a compiler nor a c library for these fonts
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

SRC_URI = "git://github.com/ppowalowski/fontface-open-sans.git;protocol=https"
SRCREV = "462165fa0e73a665d2fbc8c80ecc23ce135700da"
S = "${WORKDIR}/git"

FONT_PACKAGES = "ttf-opensans"

do_install() {
    install -d ${D}${datadir}/fonts/truetype/
    find ./ -name '*.tt[cf]' -exec install -m 0644 {} ${D}${datadir}/fonts/truetype/ \;

    install -d ${D}${datadir}/fonts/google-opensans/
    ln -s ../truetype/OpenSans-Regular.ttf ${D}/usr/share/fonts/google-opensans/OpenSans-Regular.ttf
}

FILES_${PN} += "/usr/"
